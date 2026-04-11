package com.ibrahim.simpleshop.model.response;

import com.ibrahim.simpleshop.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderSummaryResponse {
    private Long id;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private int itemCount;
    private LocalDateTime createdAt;
}
