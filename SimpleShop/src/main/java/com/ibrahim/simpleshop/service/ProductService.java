package com.ibrahim.simpleshop.service;

import com.ibrahim.simpleshop.model.request.CreateProductRequest;
import com.ibrahim.simpleshop.model.request.UpdateProductRequest;
import com.ibrahim.simpleshop.model.response.PageResponse;
import com.ibrahim.simpleshop.model.response.ProductResponse;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductResponse createProduct(CreateProductRequest request);

    ProductResponse updateProduct(UpdateProductRequest request, Long id);

    ProductResponse getProductById(Long id);

    PageResponse<ProductResponse> getAllProducts(Pageable pageable);

    void deleteProductById(Long id);
}
