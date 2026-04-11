package com.ibrahim.simpleshop.dao.repository;

import com.ibrahim.simpleshop.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    @Query("SELECT COUNT(oi) > 0 FROM OrderItem oi " +
            "WHERE oi.product.id = :productId")
    boolean existsInAnyOrderItem(Long productId);
}
