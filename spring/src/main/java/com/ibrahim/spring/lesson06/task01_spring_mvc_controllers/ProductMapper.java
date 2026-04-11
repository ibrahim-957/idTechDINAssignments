package com.ibrahim.spring.lesson06.task01_spring_mvc_controllers;

import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.CreateProductRequest;
import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.ProductDto;
import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.UpdateProductRequest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    public RowMapper<Product> rowMapper() {
        return (rs, rowNum) -> new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getBigDecimal("price"),
                rs.getString("category"),
                rs.getBoolean("is_active"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getTimestamp("updated_at").toLocalDateTime()
        );
    }

    public ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.isActive(),
                product.getCreatedAt()
        );
    }

    public List<ProductDto> toDtoList(List<Product> products) {
        return products.stream()
                .map(this::toDto)
                .toList();
    }

    public Product toEntity(CreateProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        return product;
    }

    public void applyFullUpdate(Product existing, UpdateProductRequest request) {
        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setCategory(request.getCategory());
        existing.setActive(request.getActive() != null ? request.getActive() : true);
    }

    public void applyPartialUpdate(Product existing, UpdateProductRequest request) {
        if (request.getName()        != null) existing.setName(request.getName());
        if (request.getDescription() != null) existing.setDescription(request.getDescription());
        if (request.getPrice()       != null) existing.setPrice(request.getPrice());
        if (request.getCategory()    != null) existing.setCategory(request.getCategory());
    }
}
