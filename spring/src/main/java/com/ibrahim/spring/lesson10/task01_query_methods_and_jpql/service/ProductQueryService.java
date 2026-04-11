package com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.service;

import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.dto.ProductSummaryDto;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.entity.L10T1Category;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.entity.L10T1Product;
import com.ibrahim.spring.lesson10.task01_query_methods_and_jpql.repository.L10T1ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductQueryService  {
    private final L10T1ProductRepository productRepository;

    public List<L10T1Product> findInPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findExpensive(BigDecimal threshold) {
        return productRepository.findByPriceGreaterThan(threshold);
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findByIds(List<Long> ids) {
        return productRepository.findByIdIn(ids);
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findExcludingIds(List<Long> ids) {
        return productRepository.findByIdNotIn(ids);
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findWithoutSku() {
        return productRepository.findBySkuIsNull();
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findWithSku() {
        return productRepository.findBySkuIsNotNull();
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> searchByName(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findByPrefix(String prefix) {
        return productRepository.findByNameStartingWith(prefix);
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findCheapestFirst() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findActiveByCategory(L10T1Category l10T1Category) {
        return productRepository.findByActiveTrueAndCategory(l10T1Category);
    }

    public List<L10T1Product> findByCategoryAndMaxPrice(String categoryName, BigDecimal maxPrice) {
        return productRepository.findByCategoryNameAndMaxPrice(categoryName, maxPrice);
    }

    public void printPriceAggregates(){
        List<Object[]> rows = productRepository.aggregatePriceByCategory();
        log.info("--Price Aggregates by L10T1Category -----------");
        for (Object[] row : rows) {
            Double avg = (Double) row[0];
            BigDecimal max = (BigDecimal) row[1];
            Long count = (Long) row[2];
            L10T1Category cat =  (L10T1Category) row[3];
            log.info("  L10T1Category: {:15} | avg={:8.2f} | max={:8.2f} | count={}",
                    cat.getName(), avg, max, count);
        }
    }

    public List<L10T1Product> findActiveWithCategory(){
        return productRepository.findAllActiveWithCategory();
    }

    @Transactional(readOnly = true)
    public List<L10T1Product> findCheaperThan(BigDecimal maxPrice) {
        return productRepository.findByPriceLessThanOrderByName(maxPrice);
    }

    @Transactional(readOnly = true)
    public List<ProductSummaryDto> findAllSummaries() {
        return productRepository.findAllAsSummary();
    }
}
