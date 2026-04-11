package com.ibrahim.spring.lesson09.task02_entity_lifecycle_and_entity_manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Slf4j
public class EntityLifecycleDemoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Long demonstrateManagedState(){
        log.info("═══════════════════════════════════════════");
        log.info("DEMO 1: TRANSIENT → MANAGED");
        log.info("═══════════════════════════════════════════");

        Lesson09Task2Product product = Lesson09Task2Product.builder()
                .name("Laptop")
                .price(new BigDecimal("999.99"))
                .description("Laptop")
                .build();

        log.info("[TRANSIENT]  id={}, managed={}", product.getId(), entityManager.contains(product));

        entityManager.contains(product);

        entityManager.persist(product);

        product.setName("Gaming Laptop");
        log.info("[MANAGED]    name changed to '{}' — no save() needed, " +
                "Hibernate will detect the diff at flush time", product.getName());

        return product.getId();
    }

    @Transactional
    public void demonstrateDetachedState(Long productId) {
        log.info("═══════════════════════════════════════════");
        log.info("DEMO 2: MANAGED → DETACHED → merge()");
        log.info("═══════════════════════════════════════════");

        Lesson09Task2Product product = entityManager.find(Lesson09Task2Product.class, productId);
        log.info("[MANAGED]    id={}, managed={}", product.getId(),
                entityManager.contains(product));

        entityManager.detach(product);

        log.info("[DETACHED]   id={}, managed={}", product.getId(),
                entityManager.contains(product));

        product.setPrice(new BigDecimal("1199.99"));
        log.info("[DETACHED]   price changed to {} — this change is invisible " +
                "to the persistence context right now", product.getPrice());


        Lesson09Task2Product managedCopy = entityManager.merge(product);

        log.info("[MERGED]     original managed={}, managedCopy managed={}",
                entityManager.contains(product),
                entityManager.contains(managedCopy));

        log.info("[MERGED]     managedCopy.price={} — price change now tracked, " +
                "UPDATE will fire at commit", managedCopy.getPrice());

    }

    @Transactional
    public void demonstrateRemovedState() {
        log.info("═══════════════════════════════════════════");
        log.info("DEMO 3: MANAGED → REMOVED");
        log.info("═══════════════════════════════════════════");

        Lesson09Task2Product product = Lesson09Task2Product.builder()
                .name("Temporary Lesson09Task2Product")
                .price(new BigDecimal("49.99"))
                .build();

        entityManager.persist(product);
        entityManager.flush();

        log.info("[MANAGED]    id={}, managed={}", product.getId(),
                entityManager.contains(product));

        entityManager.remove(product);

        log.info("[REMOVED]    id={}, managed={}", product.getId(),
                entityManager.contains(product));


        log.info("[REMOVED]    Java object still accessible: name='{}'",
                product.getName());

        entityManager.flush();
        log.info("[REMOVED]    DELETE SQL has been sent to DB (will rollback)");


        throw new DemoRollbackException("Intentional rollback — demo only");
    }

    @Transactional
    public void demonstrateFlushAndClear(Long productId) {
        log.info("═══════════════════════════════════════════");
        log.info("DEMO 4: flush() + clear() + find() reload");
        log.info("═══════════════════════════════════════════");

        Lesson09Task2Product product = entityManager.find(Lesson09Task2Product.class, productId);
        log.info("[MANAGED]    loaded: id={}, name='{}'",
                product.getId(), product.getName());

        product.setDescription("Updated via dirty checking");

        entityManager.flush();
        log.info("[AFTER FLUSH] UPDATE SQL sent to DB. managed={}, " +
                        "transaction still open (not committed yet)",
                entityManager.contains(product));


        entityManager.clear();
        log.info("[AFTER CLEAR] managed={} — product is now DETACHED",
                entityManager.contains(product));

        Lesson09Task2Product reloaded = entityManager.find(Lesson09Task2Product.class, productId);
        log.info("[RELOADED]   managed={}, description='{}'",
                entityManager.contains(reloaded),
                reloaded.getDescription());



        log.info("[SUMMARY]    original managed={}, reloaded managed={}",
                entityManager.contains(product),
                entityManager.contains(reloaded));
    }

    public static class DemoRollbackException extends RuntimeException {
        public DemoRollbackException(String message) {
            super(message);
        }
    }
}
