package com.ibrahim.spring.lesson09.task01_entity_mapping.repository;

import com.ibrahim.spring.lesson09.task01_entity_mapping.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface Lesson09ProductRepository extends JpaRepository<ProductEntity, UUID> {
    List<ProductEntity> findByActiveTrue();
    List<ProductEntity> findByPriceLessThanEqual(BigDecimal maxPrice);
}
