package com.ibrahim.simpleshop.model.response;

import com.ibrahim.simpleshop.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private Long userId;
    private String userEmail;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private List<OrderItemResponse> orderItems;
    private LocalDateTime createdAt;
}
