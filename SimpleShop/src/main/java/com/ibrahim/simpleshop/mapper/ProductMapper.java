package com.ibrahim.simpleshop.mapper;

import com.ibrahim.simpleshop.dao.entity.Product;
import com.ibrahim.simpleshop.model.request.CreateProductRequest;
import com.ibrahim.simpleshop.model.request.UpdateProductRequest;
import com.ibrahim.simpleshop.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    Product toEntity(CreateProductRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromRequest(UpdateProductRequest request, @MappingTarget Product product);

    ProductResponse toResponse(Product product);
}
