package com.ibrahim.spring.assetmanagement.controller;

import com.ibrahim.spring.assetmanagement.model.request.CreateDepartmentRequest;
import com.ibrahim.spring.assetmanagement.model.response.DepartmentResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.ApiResponse;
import com.ibrahim.spring.assetmanagement.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@Validated
public class V1DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentResponse>> create(
            @Valid @RequestBody CreateDepartmentRequest request){
        DepartmentResponse response = departmentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Department created successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentResponse>>> findAll(){
        return ResponseEntity.ok(ApiResponse.success(departmentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponse>> findById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.success(departmentService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponse>> deactivate(@PathVariable Long id){
        departmentService.deactivate(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Department deactivated successfully"));
    }
}
