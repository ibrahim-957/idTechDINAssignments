package com.ibrahim.spring.lesson06.task01_spring_mvc_controllers;

import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.CreateProductRequest;
import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.ProductDto;
import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> findAll() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lesson09Task2Product not found: " + id));
        return productMapper.toDto(product);
    }

    public ProductDto create(CreateProductRequest request) {
        Product product = productMapper.toEntity(request);
        product.setActive(true);
        Product saved = productRepository.save(product);
        return productMapper.toDto(saved);
    }

    public ProductDto fullUpdate(Long id, UpdateProductRequest request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lesson09Task2Product not found: " + id));

        productMapper.applyFullUpdate(existing, request);
        Product updated = productRepository.update(existing);
        return productMapper.toDto(updated);
    }

    public ProductDto partialUpdate(Long id, UpdateProductRequest request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lesson09Task2Product not found: " + id));

        productMapper.applyPartialUpdate(existing, request);
        Product updated = productRepository.update(existing);
        return productMapper.toDto(updated);
    }

    public void delete(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lesson09Task2Product not found: " + id));
        productRepository.deleteById(id);
    }

    public List<ProductDto> search(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        return productMapper.toDtoList(
                productRepository.search(name, minPrice, maxPrice)
        );
    }
}
