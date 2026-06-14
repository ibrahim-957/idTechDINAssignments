package az.ibrahim.order_service.service;

import az.ibrahim.order_service.client.InventoryClient;
import az.ibrahim.order_service.entity.Order;
import az.ibrahim.order_service.exception.NotFoundException;
import az.ibrahim.order_service.mapper.OrderMapper;
import az.ibrahim.order_service.model.OrderEventDto;
import az.ibrahim.order_service.model.OrderRequest;
import az.ibrahim.order_service.model.OrderResponse;
import az.ibrahim.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryClient inventoryClient;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.order}")
    private String exchange;

    @Value("${rabbitmq.routing-key.order}")
    private String routingKey;

    @Override
    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        inventoryClient.reduceQuantity(request.getProductId(), request.getQuantity());

        Order order = orderMapper.toEntity(request);
        order.setProductId(request.getProductId());
        order.setStatus("CREATED");
        Order savedOrder = orderRepository.save(order);

        OrderEventDto event = new OrderEventDto(
                savedOrder.getId(),
                savedOrder.getProductId(),
                savedOrder.getQuantity()
        );

        rabbitTemplate.convertAndSend(exchange, routingKey, event);
        return orderMapper.toResponse(savedOrder);
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + id));
        return orderMapper.toResponse(order);
    }
}
