/*
package com.ibrahim.spring.lesson09.task01_entity_mapping;

import com.ibrahim.spring.lesson09.task01_entity_mapping.entity.AddressEntity;
import com.ibrahim.spring.lesson09.task01_entity_mapping.entity.CategoryEntity;
import com.ibrahim.spring.lesson09.task01_entity_mapping.entity.ProductEntity;
import com.ibrahim.spring.lesson09.task01_entity_mapping.entity.UserEntity;
import com.ibrahim.spring.lesson09.task01_entity_mapping.repository.CategoryRepository;
import com.ibrahim.spring.lesson09.task01_entity_mapping.repository.Lesson09ProductRepository;
import com.ibrahim.spring.lesson09.task01_entity_mapping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class EntityMappingDemoRunner implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final Lesson09ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        log.info("==============================");
        log.info("=== POINT 1: User Entity   ===");
        log.info("==============================");

        UserEntity user = UserEntity.builder()
                .username("ibrahim")
                .email("ibrahim@example.com")
                .status(UserStatus.ACTIVE)
                .build();

        UserEntity saved = userRepository.save(user);

        log.info("Saved user — id={}, createdAt={}, updatedAt={}",
                saved.getId(), saved.getCreatedAt(), saved.getUpdatedAt());

        saved.setEmail("ibrahim.updated@example.com");
        userRepository.save(saved);

        log.info("==============================");
        log.info("=== POINT 2: Lesson09Task2Product (UUID)===");
        log.info("==============================");

        ProductEntity product = ProductEntity.builder()
                .name("Mechanical Keyboard")
                .price(new BigDecimal("149.99"))
                .description("Cherry MX Red switches")
                .longContent("Full detailed description goes here...")
                .active(true)
                .build();

        ProductEntity savedProduct = productRepository.save(product);

        log.info("Saved product — id={} (UUID), active={}",
                savedProduct.getId(), savedProduct.isActive());

        productRepository.findById(savedProduct.getId()).ifPresent(p ->
                log.info("Decrypted description: {}", p.getDescription())
        );


        log.info("==============================");
        log.info("=== POINT 3: @Embedded     ===");
        log.info("==============================");

        CategoryEntity category = CategoryEntity.builder()
                .name("Electronics")
                .address(AddressEntity.builder()
                        .street("123 Tech Street")
                        .city("Baku")
                        .country("Azerbaijan")
                        .build())
                .build();

        CategoryEntity savedCategory = categoryRepository.save(category);
        log.info("Saved category — id={}, city={}",
                savedCategory.getId(),
                savedCategory.getAddress().getCity());

        List<CategoryEntity> bakuCategories = categoryRepository.findByAddressCity("Baku");
        log.info("Categories in Baku: {}", bakuCategories.size());


        log.info("==============================");
        log.info("=== POINT 4: Enum Storage  ===");
        log.info("==============================");

        UserEntity suspended = UserEntity.builder()
                .username("suspended_user")
                .email("sus@example.com")
                .status(UserStatus.SUSPENDED)
                .build();
        userRepository.save(suspended);

        List<UserEntity> activeUsers = userRepository.findByStatus(UserStatus.ACTIVE);
        log.info("Active users count: {}", activeUsers.size());
    }
}
*/
