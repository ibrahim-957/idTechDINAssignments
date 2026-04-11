package com.ibrahim.liquibase.service;

import com.ibrahim.liquibase.dto.request.CreateProductRequest;
import com.ibrahim.liquibase.dto.request.UpdateProductRequest;
import com.ibrahim.liquibase.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest request);
    ProductResponse getProductById(Long id);
    List<ProductResponse> getAllProducts();
    ProductResponse updateProduct(Long id, UpdateProductRequest request);
}
