package com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.repository;

import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.dto.ProductSummaryDto;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.entity.L10T1Category;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.entity.L10T1Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface L10T1ProductRepository extends JpaRepository<L10T1Product, Long> {
    // 1. BETWEEN — price >= min AND price <= max
    List<L10T1Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    // 2. GREATER THAN — price > threshold
    List<L10T1Product> findByPriceGreaterThan(BigDecimal threshold);

    // 3. LESS THAN — price < threshold
    List<L10T1Product> findByPriceLessThan(BigDecimal threshold);

    // 4. IN — id in the provided collection
    List<L10T1Product> findByIdIn(List<Long> ids);

    // 5. NOT IN — id not in the provided collection
    List<L10T1Product> findByIdNotIn(List<Long> ids);

    // 6. IS NULL — sku column is null
    List<L10T1Product> findBySkuIsNull();

    // 7. IS NOT NULL — sku column is not null
    List<L10T1Product> findBySkuIsNotNull();

    // 8. LIKE — matches a raw SQL-style pattern; caller must supply % wildcards
    List<L10T1Product> findByNameLike(String pattern);

    // 9. STARTING WITH — Sugar for LIKE 'prefix%'; no wildcard needed from caller
    List<L10T1Product> findByNameStartingWith(String prefix);

    // 10. CONTAINING — Sugar for LIKE '%keyword%'
    List<L10T1Product> findByNameContaining(String keyword);

    // 11. ORDER BY (asc)
    List<L10T1Product> findAllByOrderByPriceAsc();

    // 12. ORDER BY (desc) combined with a condition
    List<L10T1Product> findByActiveTrueOrderByCreatedAtDesc();

    // 13. GREATER THAN OR EQUAL — price >= floor
    List<L10T1Product> findByPriceGreaterThanEqual(BigDecimal floor);

    // 14. L10T1Category navigation — traverses the @ManyToOne relationship
    List<L10T1Product> findByCategory(L10T1Category l10T1Category);

    // 15. Combining two predicates — active AND l10T1Category
    List<L10T1Product> findByActiveTrueAndCategory(L10T1Category l10T1Category);

    @Query("""
            SELECT p
            FROM   L10T1Product p
            WHERE  p.category.name = :catName
            AND  p.price < :maxPrice
            ORDER BY p.price ASC
            """)
    List<L10T1Product> findByCategoryNameAndMaxPrice(
            @Param("catName") String catName,
            @Param("maxPrice") BigDecimal maxPrice
    );

    @Query("""
            SELECT AVG(p.price), MAX(p.price), COUNT(p), p.category
            FROM L10T1Product p
            GROUP BY p.category
            """)
    List<Object[]> aggregatePriceByCategory();

    @Query("SELECT p FROM L10T1Product p " +
            "JOIN FETCH p.category " +
            "WHERE p.active = true")
    List<L10T1Product> findAllActiveWithCategory();

    List<L10T1Product> findByPriceLessThanOrderByName(@Param("maxPrice") BigDecimal maxPrice);

    @Query("SELECT new com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.dto.ProductSummaryDto(" +
            " p.id, p.name, p.price) " +
            "FROM L10T1Product p " +
            "ORDER BY p.name ASC ")
    List<ProductSummaryDto> findAllAsSummary();

    Optional<L10T1Product> findBySku(String sku);
}
