package com.ibrahim.simpleshop.mapper;

import com.ibrahim.simpleshop.dao.entity.Order;
import com.ibrahim.simpleshop.model.request.CreateOrderRequest;
import com.ibrahim.simpleshop.model.response.OrderResponse;
import com.ibrahim.simpleshop.model.response.OrderSummaryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {
    Order toEntity(CreateOrderRequest request);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "userEmail", source = "user.email")
    OrderResponse toResponse(Order order);

    @Mapping(target = "itemCount", expression = "java(orderCount(order))")
    OrderSummaryResponse toSummaryResponse(Order order);

    default int orderCount(Order order) {
        return order.getOrderItems().size();
    }
}
