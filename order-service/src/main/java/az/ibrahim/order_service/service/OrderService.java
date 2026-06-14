package az.ibrahim.order_service.service;

import az.ibrahim.order_service.model.OrderRequest;
import az.ibrahim.order_service.model.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest request);

    OrderResponse getOrderById(Long id);
}
