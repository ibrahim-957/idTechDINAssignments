package com.ibrahim.spring.lesson09.task02_entity_lifecycle_and_entity_manager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Slf4j
//@Component
//@RequiredArgsConstructor
/*
public class Lesson09Task02Runner implements CommandLineRunner {

    private final EntityLifecycleDemoService demoService;

    @Override
    public void run(String... args) {

        log.info("╔═══════════════════════════════════════════════╗");
        log.info("║  Lesson 09 Task 02 — JPA Entity Lifecycle     ║");
        log.info("╚═══════════════════════════════════════════════╝");

        Long productId = demoService.demonstrateManagedState();
        log.info("Demo 1 complete. Lesson09Task2Product saved with id={}", productId);


        demoService.demonstrateDetachedState(productId);
        log.info("Demo 2 complete.");

        try {
            demoService.demonstrateRemovedState();
        } catch (EntityLifecycleDemoService.DemoRollbackException e) {
            log.info("Demo 3 rolled back as expected: {}", e.getMessage());
        }

        demoService.demonstrateFlushAndClear(productId);
        log.info("Demo 4 complete.");

        log.info("╔═══════════════════════════════════════════════╗");
        log.info("║  All lifecycle demos finished.                ║");
        log.info("╚═══════════════════════════════════════════════╝");
    }
}
*/
