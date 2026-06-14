package com.ibrahim.spring.assetmanagement.mapper;

import com.ibrahim.spring.assetmanagement.entity.Employee;
import com.ibrahim.spring.assetmanagement.model.request.CreateEmployeeRequest;
import com.ibrahim.spring.assetmanagement.model.request.UpdateEmployeeRequest;
import com.ibrahim.spring.assetmanagement.model.response.EmployeeResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "assignments", ignore = true)
    Employee toEntity(CreateEmployeeRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "assignments", ignore = true)
    @Mapping(target = "active", ignore = true)
    void updateEntity(UpdateEmployeeRequest request, @MappingTarget Employee employee);

    @Mapping(target = "departmentId",
            expression = "java(employee.getDepartment().getId())")
    @Mapping(target = "departmentName",
            expression = "java(employee.getDepartment().getName())")
    @Mapping(target = "fullName",
            expression = "java(employee.getFirstName() + \" \" + employee.getLastName())")
    @Mapping(target = "activeAssignmentCount",
            expression = "java((int) employee.getAssignments().stream()" +
                    ".filter(a -> a.getReturnDate() == null).count())")
    EmployeeResponse toResponse(Employee employee);
}
