package az.ibrahim.inventory_service.service;

import az.ibrahim.inventory_service.model.ProductResponse;

public interface ProductService {
    ProductResponse getById(Long id);

    ProductResponse reduceQuantity(Long id, int quantity);
}
