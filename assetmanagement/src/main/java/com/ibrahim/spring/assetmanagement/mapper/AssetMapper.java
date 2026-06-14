package com.ibrahim.spring.assetmanagement.mapper;

import com.ibrahim.spring.assetmanagement.entity.Asset;
import com.ibrahim.spring.assetmanagement.model.request.CreateAssetRequest;
import com.ibrahim.spring.assetmanagement.model.request.UpdateAssetRequest;
import com.ibrahim.spring.assetmanagement.model.response.AssetResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AssetMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "assignments", ignore = true)
    @Mapping(target = "status", constant = "AVAILABLE")
    Asset toEntity(CreateAssetRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "assignments", ignore = true)
    @Mapping(target = "status", ignore = true)
    void updateEntity(UpdateAssetRequest request, @MappingTarget Asset entity);

    @Mapping(target = "totalAssignments",
            expression = "java(asset.getAssignments().size())")
    AssetResponse toResponse(Asset asset);
}
