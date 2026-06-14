package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.entity.Asset;
import com.ibrahim.spring.assetmanagement.entity.AssetAssignment;
import com.ibrahim.spring.assetmanagement.entity.Employee;
import com.ibrahim.spring.assetmanagement.exception.BusinessException;
import com.ibrahim.spring.assetmanagement.exception.NotFoundException;
import com.ibrahim.spring.assetmanagement.mapper.AssetAssignmentMapper;
import com.ibrahim.spring.assetmanagement.model.enums.AssetStatus;
import com.ibrahim.spring.assetmanagement.model.request.CreateAssignmentRequest;
import com.ibrahim.spring.assetmanagement.model.request.ReturnAssetRequest;
import com.ibrahim.spring.assetmanagement.model.response.AssetAssignmentResponse;
import com.ibrahim.spring.assetmanagement.repository.AssetAssignmentRepository;
import com.ibrahim.spring.assetmanagement.repository.AssetRepository;
import com.ibrahim.spring.assetmanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssetAssignmentServiceImpl implements AssetAssignmentService {
    private final AssetAssignmentRepository assignmentRepository;
    private final AssetRepository assetRepository;
    private final EmployeeRepository employeeRepository;
    private final AssetAssignmentMapper assignmentMapper;

    @Override
    @Transactional
    public AssetAssignmentResponse assign(CreateAssignmentRequest request) {
        Asset asset = assetRepository.findById(request.getAssetId())
                .orElseThrow(() -> new NotFoundException("Asset", request.getAssetId()));

        if (asset.getStatus() != AssetStatus.AVAILABLE){
            throw new BusinessException(
                    "Asset is not available for assignment. Current status: " + asset.getStatus());
        }

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new NotFoundException("Employee", request.getEmployeeId()));

        if (!employee.isActive()){
            throw new BusinessException(
                    "Cannot assign asset to an inactive employee.");
        }

        AssetAssignment assignment = AssetAssignment.builder()
                .asset(asset)
                .employee(employee)
                .assignedDate(request.getAssignedDate())
                .condition(request.getCondition())
                .notes(request.getNotes())
                .build();

        asset.setStatus(AssetStatus.ASSIGNED);
        AssetAssignment saved = assignmentRepository.save(assignment);
        log.info("Assigned asset {} to employee {}", asset.getId(), employee.getId());

        return assignmentMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public AssetAssignmentResponse returnAsset(Long assignmentId, ReturnAssetRequest request) {
        AssetAssignment assignment = assignmentRepository.findByIdWithDetails(assignmentId)
                .orElseThrow(() -> new NotFoundException("Assignment", assignmentId));

        if (assignment.getReturnDate() != null){
            throw new BusinessException("This asset has already been returned.");
        }

        assignment.setReturnDate(request.getReturnDate());
        assignment.setCondition(request.getCondition());
        assignment.setNotes(request.getNotes());
        assignment.getAsset().setStatus(AssetStatus.AVAILABLE);
        return assignmentMapper.toResponse(assignmentRepository.save(assignment));
    }

    @Override
    public List<AssetAssignmentResponse> findActiveByEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new NotFoundException("Employee", employeeId);
        }
        return assignmentRepository.findActiveByEmployeeId(employeeId).stream()
                .map(assignmentMapper::toResponse)
                .toList();
    }

    @Override
    public List<AssetAssignmentResponse> findByAsset(Long assetId) {
        if (!assetRepository.existsById(assetId)){
            throw new NotFoundException("Asset", assetId);
        }
        return assignmentRepository.findAllByAssetId(assetId).stream()
                .map(assignmentMapper::toResponse)
                .toList();
    }

    @Override
    public AssetAssignmentResponse findById(Long id) {
        return assignmentRepository.findByIdWithDetails(id)
                .map(assignmentMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Assignment", id));
    }
}
