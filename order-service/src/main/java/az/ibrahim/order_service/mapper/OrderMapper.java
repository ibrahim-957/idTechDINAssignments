package az.ibrahim.order_service.mapper;

import az.ibrahim.order_service.entity.Order;
import az.ibrahim.order_service.model.OrderEventDto;
import az.ibrahim.order_service.model.OrderRequest;
import az.ibrahim.order_service.model.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id",        ignore = true)
    @Mapping(target = "status",    ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Order toEntity(OrderRequest request);

    @Mapping(source = "id", target = "orderId")
    OrderResponse toResponse(Order order);

    @Mapping(source = "id", target = "orderId")
    OrderEventDto toEventDto(Order order);
}