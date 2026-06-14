package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.model.request.CreateEmployeeRequest;
import com.ibrahim.spring.assetmanagement.model.request.EmployeeSearchRequest;
import com.ibrahim.spring.assetmanagement.model.request.UpdateEmployeeRequest;
import com.ibrahim.spring.assetmanagement.model.response.EmployeeResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.PageResponse;

import java.util.List;

public interface EmployeeService {
    PageResponse<EmployeeResponse> search(EmployeeSearchRequest request);

    EmployeeResponse findById(Long id);

    EmployeeResponse create(CreateEmployeeRequest request);

    EmployeeResponse update(Long id, UpdateEmployeeRequest request);

    void deactivate(Long id);

    List<EmployeeResponse> findByDepartment(Long departmentId);
}
