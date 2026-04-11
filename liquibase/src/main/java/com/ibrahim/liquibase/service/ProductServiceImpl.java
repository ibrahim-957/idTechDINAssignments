package com.ibrahim.liquibase.service;

import com.ibrahim.liquibase.dto.request.CreateProductRequest;
import com.ibrahim.liquibase.dto.request.UpdateProductRequest;
import com.ibrahim.liquibase.dto.response.ProductResponse;
import com.ibrahim.liquibase.entity.Product;
import com.ibrahim.liquibase.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .createdAt(LocalDateTime.now())
                .build();
        Product saved = productRepository.save(product);
        return saved;
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductResponse updateProduct(Long id, UpdateProductRequest request) {
        return null;
    }
}
