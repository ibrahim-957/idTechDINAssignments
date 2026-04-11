package com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.dto;

import java.math.BigDecimal;

public record ProductSummaryDto(Long id, String name, BigDecimal price) {
}
