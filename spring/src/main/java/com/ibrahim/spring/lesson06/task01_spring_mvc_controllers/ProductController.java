package com.ibrahim.spring.lesson06.task01_spring_mvc_controllers;

import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.CreateProductRequest;
import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.ProductDto;
import com.ibrahim.spring.lesson06.task01_spring_mvc_controllers.dto.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody CreateProductRequest request) {
        return productService.create(request);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id,
                                    @RequestBody UpdateProductRequest request) {
        return productService.fullUpdate(id, request);
    }

    @PatchMapping("/{id}")
    public ProductDto partialUpdate(@PathVariable Long id,
                                    @RequestBody UpdateProductRequest request) {
        return productService.partialUpdate(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {
        return productService.search(name, minPrice, maxPrice);
    }
}
