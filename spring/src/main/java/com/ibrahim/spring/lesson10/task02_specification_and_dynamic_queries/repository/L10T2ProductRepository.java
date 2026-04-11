package com.ibrahim.spring.lesson10.task02_specification_and_dynamic_queries.repository;

import com.ibrahim.spring.lesson10.task02_specification_and_dynamic_queries.entity.L10T2Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface L10T2ProductRepository
        extends JpaRepository<L10T2Product, Long>,
        JpaSpecificationExecutor<L10T2Product> {

}
