package com.ibrahim.simpleshop.controller;

import com.ibrahim.simpleshop.model.request.CreateProductRequest;
import com.ibrahim.simpleshop.model.request.UpdateProductRequest;
import com.ibrahim.simpleshop.model.response.PageResponse;
import com.ibrahim.simpleshop.model.response.ProductResponse;
import com.ibrahim.simpleshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/products")
@RequiredArgsConstructor
public class V1ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<PageResponse<ProductResponse>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ){
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return ResponseEntity.ok(productService.getAllProducts(PageRequest.of(page, size, sort)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @RequestBody CreateProductRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @RequestBody UpdateProductRequest request
    ) {
        return ResponseEntity.ok(productService.updateProduct(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
