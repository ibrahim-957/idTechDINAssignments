package com.ibrahim.spring.assetmanagement.controller;

import com.ibrahim.spring.assetmanagement.model.request.CreateEmployeeRequest;
import com.ibrahim.spring.assetmanagement.model.request.EmployeeSearchRequest;
import com.ibrahim.spring.assetmanagement.model.request.UpdateEmployeeRequest;
import com.ibrahim.spring.assetmanagement.model.response.EmployeeResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.ApiResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.PageResponse;
import com.ibrahim.spring.assetmanagement.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
@Validated
public class V1EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> created(
            @Valid @RequestBody CreateEmployeeRequest request){
        EmployeeResponse employeeResponse = employeeService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(employeeResponse, "Employee created successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<EmployeeResponse>>> search(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) Boolean active,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "lastName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        EmployeeSearchRequest request = new EmployeeSearchRequest(
                firstName, lastName, departmentId, active, page, size, sortBy, sortDir);

        return ResponseEntity.ok(ApiResponse.success(employeeService.search(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(employeeService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateEmployeeRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(employeeService.update(id, request), "Employee updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deactivate(@PathVariable Long id) {
        employeeService.deactivate(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Employee deactivated successfully"));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> findByDepartment(
            @PathVariable Long departmentId) {
        return ResponseEntity.ok(ApiResponse.success(employeeService.findByDepartment(departmentId)));
    }
}
