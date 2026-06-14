package az.ibrahim.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDTO implements Serializable {
    private Long orderId;
    private Long productId;
    private int quantity;
}
