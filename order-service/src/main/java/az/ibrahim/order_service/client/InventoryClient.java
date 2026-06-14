package az.ibrahim.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service", url = "http://localhost:8082")
public interface InventoryClient {

    @PutMapping("/v1/api/products/{productId}/reduce")
    void reduceQuantity(
            @PathVariable Long productId,
            @RequestParam("quantity") Integer quantity);
}
