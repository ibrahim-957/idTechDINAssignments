package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.entity.Department;
import com.ibrahim.spring.assetmanagement.exception.BusinessException;
import com.ibrahim.spring.assetmanagement.exception.NotFoundException;
import com.ibrahim.spring.assetmanagement.mapper.DepartmentMapper;
import com.ibrahim.spring.assetmanagement.model.request.CreateDepartmentRequest;
import com.ibrahim.spring.assetmanagement.model.response.DepartmentResponse;
import com.ibrahim.spring.assetmanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentResponse> findAll() {
        log.info("Fetching all departments");
        return departmentRepository.findByActiveTrue().stream()
                .map(departmentMapper::toResponse)
                .toList();
    }

    @Override
    public DepartmentResponse findById(Long id) {
        Department department = departmentRepository.findByIdWithEmployees(id)
                .orElseThrow(() -> new NotFoundException("Department", id));
        return departmentMapper.toResponse(department);
    }

    @Override
    @Transactional
    public DepartmentResponse create(CreateDepartmentRequest request) {
        if (departmentRepository.existsByNameIgnoreCase(request.getName())) {
            throw new BusinessException("Department with name " + request.getName() + " already exists");
        }

        Department department = departmentMapper.toEntity(request);
        Department saved = departmentRepository.save(department);
        log.info("Created Department with id {}", saved.getId());
        return departmentMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public void deactivate(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Department", id));
        department.setActive(false);
        log.info("Department with id {} has been deactivated", id);
    }
}
