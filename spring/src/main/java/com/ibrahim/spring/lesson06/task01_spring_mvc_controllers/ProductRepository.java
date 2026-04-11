package com.ibrahim.spring.lesson06.task01_spring_mvc_controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;

    public List<Product> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM products_lesson06_task1 ORDER BY created_at DESC",
                productMapper.rowMapper()
        );
    }

    public Optional<Product> findById(Long id) {
        List<Product> results = jdbcTemplate.query(
                "SELECT * FROM products_lesson06_task1 WHERE id = ?",
                productMapper.rowMapper(),
                id
        );
        return results.stream().findFirst();
    }

    public Product save(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO products_lesson06_task1 (name, description, price, category, is_active) " +
                            "VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setBigDecimal(3, product.getPrice());
            ps.setString(4, product.getCategory());
            ps.setBoolean(5, product.isActive());
            return ps;
        }, keyHolder);

        Long generatedId = ((Number) keyHolder.getKeys().get("id")).longValue();
        product.setId(generatedId);
        return product;
    }


    public Product update(Product product) {
        jdbcTemplate.update(
                "UPDATE products_lesson06_task1 SET name=?, description=?, price=?, category=?, " +
                        "is_active=?, updated_at=NOW() WHERE id=?",
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory(),
                product.isActive(),
                product.getId()
        );
        return product;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM products_lesson06_task1 WHERE id = ?", id);
    }

    public List<Product> search(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        StringBuilder sql = new StringBuilder("SELECT * FROM products_lesson06_task1 WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (name != null && !name.isBlank()) {
            sql.append(" AND LOWER(name) LIKE LOWER(?)");
            params.add("%" + name + "%");
        }
        if (minPrice != null) {
            sql.append(" AND price >= ?");
            params.add(minPrice);
        }
        if (maxPrice != null) {
            sql.append(" AND price <= ?");
            params.add(maxPrice);
        }

        sql.append(" ORDER BY created_at DESC");

        return jdbcTemplate.query(sql.toString(), productMapper.rowMapper(), params.toArray());
    }
}
