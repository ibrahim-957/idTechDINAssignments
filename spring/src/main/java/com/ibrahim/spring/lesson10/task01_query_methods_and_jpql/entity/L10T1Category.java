package com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "l10t1_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class L10T1Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    public L10T1Category(String name) {
        this.name = name;
    }
}
