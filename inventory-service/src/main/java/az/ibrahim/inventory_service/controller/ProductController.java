package az.ibrahim.inventory_service.controller;

import az.ibrahim.inventory_service.model.ApiResponse;
import az.ibrahim.inventory_service.model.ProductResponse;
import az.ibrahim.inventory_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductResponse>> getProductById(@PathVariable Long productId){
        return ResponseEntity
                .ok(ApiResponse.success(productService.getById(productId)));
    }

    @PutMapping("/{productId}/reduce")
    public ResponseEntity<ApiResponse<ProductResponse>> reduceProduct(
            @PathVariable Long productId,
            @RequestParam int quantity) {
        return ResponseEntity
                .ok(ApiResponse.success(productService.reduceQuantity(productId, quantity)));
    }
}
