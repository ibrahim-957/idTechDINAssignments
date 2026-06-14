package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.entity.Department;
import com.ibrahim.spring.assetmanagement.entity.Employee;
import com.ibrahim.spring.assetmanagement.exception.BusinessException;
import com.ibrahim.spring.assetmanagement.exception.NotFoundException;
import com.ibrahim.spring.assetmanagement.mapper.EmployeeMapper;
import com.ibrahim.spring.assetmanagement.model.request.CreateEmployeeRequest;
import com.ibrahim.spring.assetmanagement.model.request.EmployeeSearchRequest;
import com.ibrahim.spring.assetmanagement.model.request.UpdateEmployeeRequest;
import com.ibrahim.spring.assetmanagement.model.response.EmployeeResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.PageResponse;
import com.ibrahim.spring.assetmanagement.repository.DepartmentRepository;
import com.ibrahim.spring.assetmanagement.repository.EmployeeRepository;
import com.ibrahim.spring.assetmanagement.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private static final Set<String> ALLOWED_SORT_FIELDS =
            Set.of("lastName", "firstName", "email", "createdAt");
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public PageResponse<EmployeeResponse> search(EmployeeSearchRequest request) {
        String sortBy = ALLOWED_SORT_FIELDS.contains(request.getSortBy())
                ? request.getSortBy() : "lastName";

        Sort sort = "desc".equalsIgnoreCase(request.getSortDir())
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Specification<Employee> spec = Specification
                .where(EmployeeSpecification.hasFirstName(request.getFirstName()))
                .and(EmployeeSpecification.hasLastName(request.getLastName()))
                .and(EmployeeSpecification.hadDepartment(request.getDepartmentId()))
                .and(EmployeeSpecification.isActive(request.getActive()));

        Page<EmployeeResponse> page = employeeRepository
                .findAll(spec, pageable)
                .map(employeeMapper::toResponse);
        return PageResponse.from(page);
    }

    @Override
    public EmployeeResponse findById(Long id) {
        Employee employee = employeeRepository.findByIdWithDepartment(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
        return employeeMapper.toResponse(employee);
    }

    @Override
    @Transactional
    public EmployeeResponse create(CreateEmployeeRequest request) {
        if (employeeRepository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new BusinessException("Email already in use: " + request.getEmail());
        }

        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new NotFoundException("Department", request.getDepartmentId()));
        Employee employee = employeeMapper.toEntity(request);
        employee.setDepartment(department);
        Employee saved = employeeRepository.save(employee);
        log.info("Created employee with id {}", saved.getId());
        return employeeMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public EmployeeResponse update(Long id, UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findByIdWithDepartment(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
        if (request.getEmail() != null &&
                employeeRepository.existsByEmailIgnoreCaseAndIdNot(request.getEmail(), id)) {
            throw new BusinessException("Email already in use: " + request.getEmail());
        }

        if (request.getDepartmentId() != null &&
                !request.getDepartmentId().equals(employee.getDepartment().getId())) {
            Department department = departmentRepository.findById(request.getDepartmentId())
                    .orElseThrow(() -> new NotFoundException("Department", request.getDepartmentId()));
            employee.setDepartment(department);
        }
        employeeMapper.updateEntity(request, employee);
        log.info("Updated employee with id {}", id);
        return employeeMapper.toResponse(employee);
    }

    @Override
    @Transactional
    public void deactivate(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee", id));
        employee.setActive(false);
        log.info("Deactivated employee with id {}", id);
    }

    @Override
    public List<EmployeeResponse> findByDepartment(Long departmentId) {
        if (!departmentRepository.existsById(departmentId)) {
            throw new NotFoundException("Department", departmentId);
        }
        return employeeRepository.findByDepartmentIdAndActiveTrue(departmentId).stream()
                .map(employeeMapper::toResponse)
                .toList();
    }
}
