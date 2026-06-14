package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.model.request.CreateDepartmentRequest;
import com.ibrahim.spring.assetmanagement.model.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> findAll();
    DepartmentResponse findById(Long id);
    DepartmentResponse create(CreateDepartmentRequest request);
    void deactivate(Long id);
}
