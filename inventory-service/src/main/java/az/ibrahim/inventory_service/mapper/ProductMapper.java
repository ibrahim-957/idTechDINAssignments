package az.ibrahim.inventory_service.mapper;

import az.ibrahim.inventory_service.entity.Product;
import az.ibrahim.inventory_service.model.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toResponse(Product product);
}