package com.ibrahim.simpleshop.controller;

import com.ibrahim.simpleshop.model.request.CreateOrderRequest;
import com.ibrahim.simpleshop.model.response.OrderResponse;
import com.ibrahim.simpleshop.model.response.PageResponse;
import com.ibrahim.simpleshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/orders")
public class V1OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.createOrder(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("/by-email/paged")
    public ResponseEntity<PageResponse<OrderResponse>> getOrdersByEmailPaged(
            @RequestParam String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        return ResponseEntity.ok(orderService.getOrdersByUserEmail(email, PageRequest.of(page, size, sort)));
    }

    @DeleteMapping("/{orderId}/items/{itemId}")
    public ResponseEntity<OrderResponse> removeOrderItem(
            @PathVariable Long orderId,
            @PathVariable Long itemId
    ) {
        return ResponseEntity.ok(orderService.removeOrderItem(orderId, itemId));
    }
}
