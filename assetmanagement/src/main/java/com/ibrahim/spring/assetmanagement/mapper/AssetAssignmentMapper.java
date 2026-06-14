package com.ibrahim.spring.assetmanagement.mapper;

import com.ibrahim.spring.assetmanagement.entity.AssetAssignment;
import com.ibrahim.spring.assetmanagement.model.response.AssetAssignmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssetAssignmentMapper {
    @Mapping(target = "assetId",
            expression = "java(assignment.getAsset().getId())")
    @Mapping(target = "assetName",
            expression = "java(assignment.getAsset().getName())")
    @Mapping(target = "assetSerialNumber",
            expression = "java(assignment.getAsset().getSerialNumber())")
    @Mapping(target = "employeeId",
            expression = "java(assignment.getEmployee().getId())")
    @Mapping(target = "employeeFullName",
            expression = "java(assignment.getEmployee().getFirstName() + \" \" + assignment.getEmployee().getLastName())")
    @Mapping(target = "active",
            expression = "java(assignment.getReturnDate() == null)")
    AssetAssignmentResponse toResponse(AssetAssignment assignment);
}
