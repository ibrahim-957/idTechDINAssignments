package com.ibrahim.simpleshop.service;

import com.ibrahim.simpleshop.dao.entity.Order;
import com.ibrahim.simpleshop.dao.entity.OrderItem;
import com.ibrahim.simpleshop.dao.entity.Product;
import com.ibrahim.simpleshop.dao.entity.User;
import com.ibrahim.simpleshop.dao.repository.OrderRepository;
import com.ibrahim.simpleshop.dao.repository.ProductRepository;
import com.ibrahim.simpleshop.dao.repository.UserRepository;
import com.ibrahim.simpleshop.mapper.OrderMapper;
import com.ibrahim.simpleshop.model.request.CreateOrderItemRequest;
import com.ibrahim.simpleshop.model.request.CreateOrderRequest;
import com.ibrahim.simpleshop.model.response.OrderResponse;
import com.ibrahim.simpleshop.model.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Override
    public PageResponse<OrderResponse> getOrdersByUserEmail(String email, Pageable pageable) {
        return PageResponse.of(
                orderRepository.findAllByUserEmailWithItems(email, pageable),
                orderMapper::toResponse
        );
    }

    @Override
    public OrderResponse createOrder(CreateOrderRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Long> productIds = request.getItems().stream()
                .map(CreateOrderItemRequest::getProductId)
                .toList();

        List<Product> products = productRepository.findAllById(productIds);

        var productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, p -> p));
        Order order = Order.builder()
                .user(user)
                .orderItems(new ArrayList<>())
                .build();

        request.getItems().forEach(item -> {
            Product product = productMap.get(item.getProductId());
            OrderItem orderItem = new OrderItem(product, item.getQuantity());
            order.addOrderItem(orderItem);
        });

        order.recalculateTotal();

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toResponse(savedOrder);
    }

    @Override
    public OrderResponse removeOrderItem(Long orderId, Long orderItemId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        OrderItem itemToRemove = order.getOrderItems().stream()
                .filter(i -> i.getId().equals(orderItemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item not found"));

        order.removeOrderItem(itemToRemove);
        order.recalculateTotal();
        return orderMapper.toResponse(order);
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toResponse(order);
    }
}
