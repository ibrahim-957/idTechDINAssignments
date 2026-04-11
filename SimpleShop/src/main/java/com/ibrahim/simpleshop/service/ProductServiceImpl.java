package com.ibrahim.simpleshop.service;

import com.ibrahim.simpleshop.dao.entity.Product;
import com.ibrahim.simpleshop.dao.repository.ProductRepository;
import com.ibrahim.simpleshop.mapper.ProductMapper;
import com.ibrahim.simpleshop.model.request.CreateProductRequest;
import com.ibrahim.simpleshop.model.request.UpdateProductRequest;
import com.ibrahim.simpleshop.model.response.PageResponse;
import com.ibrahim.simpleshop.model.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        Product product = productMapper.toEntity(request);
        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse updateProduct(UpdateProductRequest request, Long id) {
        Product product = findById(id);
        productMapper.updateEntityFromRequest(request, product);
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productMapper.toResponse(findById(id));
    }

    @Override
    public PageResponse<ProductResponse> getAllProducts(Pageable pageable) {
        return PageResponse.of(
                productRepository.findAll(pageable),
                productMapper::toResponse
        );
    }

    @Override
    public void deleteProductById(Long id) {
        if (productRepository.existsInAnyOrderItem(id)){
            throw new IllegalStateException("Cannot delete product with id " + id);
        }
        productRepository.deleteById(id);
    }

    private Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
}
