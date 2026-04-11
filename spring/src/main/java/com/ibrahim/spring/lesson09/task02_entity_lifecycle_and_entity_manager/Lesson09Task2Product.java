package com.ibrahim.spring.lesson09.task02_entity_lifecycle_and_entity_manager;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "l9t2_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson09Task2Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(length = 255)
    private String description;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
