package com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.runner;

import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.dto.ProductSummaryDto;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.entity.L10T1Category;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.entity.L10T1Product;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.repository.L10T1ProductRepository;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.service.ProductQueryService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Component
@Profile("!test")
@RequiredArgsConstructor
public class QueryDemoRunner implements CommandLineRunner {
    private final EntityManager em;
    private final L10T1ProductRepository repo;
    private final ProductQueryService service;

    @Override
    @Transactional
    public void run(String... args) {
        L10T1Category electronics = new L10T1Category("Electronics");
        L10T1Category clothing    = new L10T1Category("Clothing");
        em.persist(electronics);
        em.persist(clothing);

        em.persist(new L10T1Product("Laptop Pro 15",    new BigDecimal("1299.99"), "LP-001", true,  electronics));
        em.persist(new L10T1Product("Wireless Mouse",   new BigDecimal("29.99"),   "WM-002", true,  electronics));
        em.persist(new L10T1Product("USB-C Hub",        new BigDecimal("49.99"),   "UC-003", true,  electronics));
        em.persist(new L10T1Product("Mechanical KB",    new BigDecimal("149.99"),  null,     true,  electronics));  // no SKU
        em.persist(new L10T1Product("4K Monitor",       new BigDecimal("399.99"),  "MN-005", false, electronics));  // inactive
        em.persist(new L10T1Product("Running Shoes",    new BigDecimal("89.99"),   "RS-006", true,  clothing));
        em.persist(new L10T1Product("Winter Jacket",    new BigDecimal("199.99"),  "WJ-007", true,  clothing));
        em.persist(new L10T1Product("Cotton T-Shirt",   new BigDecimal("19.99"),   null,     true,  clothing));     // no SKU
        em.flush();

        separator("1 · findByPriceBetween(20, 100)");
        repo.findByPriceBetween(bd("20"), bd("100"))
                .forEach(p -> log.info("  {} — {}", p.getName(), p.getPrice()));

        separator("2 · findByPriceGreaterThan(100)");
        repo.findByPriceGreaterThan(bd("100"))
                .forEach(p -> log.info("  {} — {}", p.getName(), p.getPrice()));

        separator("3 · findByIdIn([1,2,3])");
        repo.findByIdIn(List.of(1L, 2L, 3L))
                .forEach(p -> log.info("  id={} name={}", p.getId(), p.getName()));

        separator("4 · findByIdNotIn([1,2,3])");
        repo.findByIdNotIn(List.of(1L, 2L, 3L))
                .forEach(p -> log.info("  id={} name={}", p.getId(), p.getName()));

        separator("5 · findBySkuIsNull() — products without a SKU");
        repo.findBySkuIsNull()
                .forEach(p -> log.info("  {} (sku=null)", p.getName()));

        separator("6 · findBySkuIsNotNull()");
        repo.findBySkuIsNotNull()
                .forEach(p -> log.info("  {} sku={}", p.getName(), p.getSku()));

        separator("7 · findByNameLike('%Mouse%') — raw LIKE");
        repo.findByNameLike("%Mouse%")
                .forEach(p -> log.info("  {}", p.getName()));

        separator("8 · findByNameStartingWith('W')");
        repo.findByNameStartingWith("W")
                .forEach(p -> log.info("  {}", p.getName()));

        separator("9 · findByNameContaining('o')");
        repo.findByNameContaining("o")
                .forEach(p -> log.info("  {}", p.getName()));

        separator("10 · findAllByOrderByPriceAsc()");
        repo.findAllByOrderByPriceAsc()
                .forEach(p -> log.info("  {} — {}", p.getPrice(), p.getName()));

        separator("11 · findByActiveTrueOrderByCreatedAtDesc()");
        repo.findByActiveTrueOrderByCreatedAtDesc()
                .forEach(p -> log.info("  {} active={}", p.getName(), p.isActive()));

        separator("12 · findByPriceGreaterThanEqual(199.99)");
        repo.findByPriceGreaterThanEqual(bd("199.99"))
                .forEach(p -> log.info("  {} — {}", p.getName(), p.getPrice()));

        separator("13 · findByCategory(electronics)");
        repo.findByCategory(electronics)
                .forEach(p -> log.info("  {}", p.getName()));

        separator("14 · findByActiveTrueAndCategory(clothing)");
        repo.findByActiveTrueAndCategory(clothing)
                .forEach(p -> log.info("  {} active={}", p.getName(), p.isActive()));

        // ── JPQL filter ─────────────────────────────────────────────────────────
        separator("15 · JPQL filter — Electronics under 200");
        service.findByCategoryAndMaxPrice("Electronics", bd("200"))
                .forEach(p -> log.info("  {} — {}", p.getName(), p.getPrice()));

        // ── JPQL aggregate ───────────────────────────────────────────────────────
        separator("16 · JPQL aggregate — price stats per category");
        service.printPriceAggregates();

        // ── JOIN FETCH ────────────────────────────────────────────────────────────
        separator("17 · JOIN FETCH — active products with category loaded");
        // These products are fetched with JOIN FETCH p.category.
        // p.getL10T1Category().getName() works safely here because the category is
        // already in memory — Hibernate does NOT issue a second query.
        service.findActiveWithCategory()
                .forEach(p -> log.info("  {} → category: {}",
                        p.getName(), p.getCategory().getName()));

        // ── @NamedQuery ─────────────────────────────────────────────────────────
        separator("18 · @NamedQuery — products cheaper than 100, sorted by name");
        service.findCheaperThan(bd("100"))
                .forEach(p -> log.info("  {} — {}", p.getName(), p.getPrice()));

        // ── Constructor expression ─────────────────────────────────────────────
        separator("19 · Constructor expression → ProductSummaryDto");
        // Each row is a ProductSummaryDto record — NOT a managed entity.
        // No LazyInitializationException risk; no dirty checking overhead.
        List<ProductSummaryDto> summaries = service.findAllSummaries();
        summaries.forEach(dto ->
                log.info("  ProductSummaryDto(id={}, name={}, price={})",
                        dto.id(), dto.name(), dto.price()));
    }

    private static BigDecimal bd(String val){
        return new BigDecimal(val);
    }

    private static void separator(String title){
        System.out.printf("%n━━━ %s %s%n", title,
                "━".repeat(Math.max(0, 60 - title.length())));
    }
}
