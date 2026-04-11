package com.ibrahim.simpleshop.mapper;

import com.ibrahim.simpleshop.dao.entity.OrderItem;
import com.ibrahim.simpleshop.model.response.OrderItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.math.BigDecimal;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderItemMapper {

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "subtotal", expression = "java(subtotal(orderItem))")
    OrderItemResponse toResponse(OrderItem orderItem);

    default BigDecimal subtotal(OrderItem orderItem) {
        return orderItem.getUnitPrice()
                .multiply(BigDecimal.valueOf(orderItem.getQuantity()))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
