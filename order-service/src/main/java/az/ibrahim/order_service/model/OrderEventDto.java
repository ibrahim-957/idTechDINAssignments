package az.ibrahim.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDto implements Serializable {
    private Long orderId;
    private Long productId;
    private Integer quantity;
}
