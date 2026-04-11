package com.ibrahim.spring.lesson09.task01_entity_mapping.repository;

import com.ibrahim.spring.lesson09.task01_entity_mapping.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findByAddressCity(String city);
}
