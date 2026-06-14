package az.ibrahim.inventory_service.service;

import az.ibrahim.inventory_service.entity.Product;
import az.ibrahim.inventory_service.exception.InsufficientStockException;
import az.ibrahim.inventory_service.exception.NotFoundException;
import az.ibrahim.inventory_service.mapper.ProductMapper;
import az.ibrahim.inventory_service.model.ProductResponse;
import az.ibrahim.inventory_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));

        return productMapper.toResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse reduceQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id " + id));

        if (product.getQuantity() < quantity) {
            throw new InsufficientStockException("Insufficient stock for product '" + product.getName() + "' Available: "
            + product.getQuantity());
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        return productMapper.toResponse(product);
    }
}
