package com.idtech.cardservice.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TableRepository {
    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
        var sql = """
                CREATE TABLE IF NOT EXISTS cards
                (
                    id          SERIAL PRIMARY KEY,
                    holder_name VARCHAR(255)   NOT NULL,
                    pan         VARCHAR(16)    NOT NULL UNIQUE,
                    cvv         VARCHAR(3)     NOT NULL,
                    expiry_date DATE           NOT NULL,
                    balance     DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
                    status      VARCHAR(10)    NOT NULL DEFAULT 'ACTIVE'
                );
                """;
        jdbcTemplate.execute(sql);
    }
}
