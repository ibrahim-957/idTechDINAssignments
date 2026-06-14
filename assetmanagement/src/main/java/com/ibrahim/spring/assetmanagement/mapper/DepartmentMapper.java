package com.ibrahim.spring.assetmanagement.mapper;

import com.ibrahim.spring.assetmanagement.entity.Department;
import com.ibrahim.spring.assetmanagement.model.request.CreateDepartmentRequest;
import com.ibrahim.spring.assetmanagement.model.response.DepartmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "employees", ignore = true)
    Department toEntity(CreateDepartmentRequest request);

    @Mapping(target = "employeeCount", expression = "java(department.getEmployees().size())")
    DepartmentResponse  toResponse(Department department);
}
