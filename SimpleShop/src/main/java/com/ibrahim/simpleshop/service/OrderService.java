package com.ibrahim.simpleshop.service;

import com.ibrahim.simpleshop.model.request.CreateOrderRequest;
import com.ibrahim.simpleshop.model.response.OrderResponse;
import com.ibrahim.simpleshop.model.response.PageResponse;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    PageResponse<OrderResponse> getOrdersByUserEmail(String email, Pageable pageable);

    OrderResponse createOrder(CreateOrderRequest request);

    OrderResponse removeOrderItem(Long orderId, Long orderItemId);

    OrderResponse getOrderById(Long id);
}
