package com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NamedQuery(
        name  = "Product.findByPriceLessThanOrderByName",
        query = "SELECT p FROM L10T1Product p WHERE p.price < :maxPrice ORDER BY p.name ASC"
)
@Entity
@Table(name = "l10t1_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class L10T1Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(length = 50)
    private String sku;

    private boolean active = true;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private L10T1Category category;

    public L10T1Product(String name, BigDecimal price, String sku,
                        boolean active, L10T1Category category) {
        this.name     = name;
        this.price    = price;
        this.sku      = sku;
        this.active   = active;
        this.category = category;
    }
}
