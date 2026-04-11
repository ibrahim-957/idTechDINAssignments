package com.ibrahim.spring.lesson09.task03_data_jpa_repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserQueryDemoService {
    private final L9T2UserRepository userRepository;

    @Transactional
    public void seedUsers() {
        List<User> users = List.of(
                User.builder().username("alice_dev").email("alice@gmail.com").active(true).loginCount(42).build(),
                User.builder().username("alice_qa").email("alice.qa@gmail.com").active(true).loginCount(15).build(),
                User.builder().username("bob_admin").email("bob@company.com").active(true).loginCount(87).build(),
                User.builder().username("carol").email("carol@company.com").active(false).loginCount(3).build(),
                User.builder().username("dave").email("dave@gmail.com").active(true).loginCount(120).build(),
                User.builder().username("eve_ops").email("eve@company.com").active(true).loginCount(55).build(),
                User.builder().username("frank").email("frank@outlook.com").active(false).loginCount(1).build(),
                User.builder().username("grace_dev").email("grace@gmail.com").active(true).loginCount(99).build()
        );
        userRepository.saveAll(users);
        log.info("[Seed] Saved {} users", users.size());
    }

    @Transactional(readOnly = true)
    public void demoDerivedQueries() {
        log.info("─── Derived query methods ───────────────────────────────────");

        userRepository.findByEmail("alice@gmail.com")
                .ifPresentOrElse(
                        u -> log.info("[findByEmail] found: {}", u.getUsername()),
                        () -> log.info("[findByEmail] not found")
                );

        List<User> alices = userRepository.findByUsernameContainingIgnoreCase("ALICE");
        log.info("[containsIgnoreCase 'ALICE'] found {} users: {}",
                alices.size(),
                alices.stream().map(User::getUsername).toList());

        LocalDateTime from = LocalDateTime.now().minusMinutes(5);
        LocalDateTime to   = LocalDateTime.now().plusMinutes(1);
        List<User> recent  = userRepository.findByCreatedAtBetween(from, to);
        log.info("[createdAtBetween] {} users created in the last 5 minutes", recent.size());

        List<User> active = userRepository.findByActiveTrue();
        log.info("[findByActiveTrue] {} active users", active.size());

        boolean exists = userRepository.existsByEmail("dave@gmail.com");
        log.info("[existsByEmail 'dave@gmail.com'] → {}", exists);
    }

    @Transactional(readOnly = true)
    public void demoJpqlQuery() {
        log.info("─── @Query JPQL ─────────────────────────────────────────────");

        List<User> result = userRepository.findByUsernamePrefix("alice");
        log.info("[JPQL prefix 'alice'] {} users, ordered by createdAt DESC:", result.size());
        result.forEach(u -> log.info("  {} (created {})", u.getUsername(), u.getCreatedAt()));
    }

    @Transactional(readOnly = true)
    public void demoNativeQuery() {
        log.info("─── @Query nativeQuery ──────────────────────────────────────");

        List<User> top5 = userRepository.findTop5ByLoginCount();
        log.info("[Native top5 by loginCount]:");
        top5.forEach(u -> log.info("  #{} {} — loginCount={}", u.getId(), u.getUsername(), u.getLoginCount()));
    }

    @Transactional   // @Modifying queries REQUIRE a transaction
    public void demoBulkUpdate() {
        log.info("─── @Modifying bulk update ──────────────────────────────────");

        // Deactivate the first 3 users by ID
        List<Long> idsToDeactivate = List.of(1L, 2L, 3L);
        int updated = userRepository.bulkUpdateActiveStatus(false, idsToDeactivate);
        log.info("[bulkUpdate] Deactivated {} rows (ids={})", updated, idsToDeactivate);

        // Because clearAutomatically = true, the PC was cleared after the UPDATE.
        // find() now loads fresh data from the DB — no stale snapshots.
        userRepository.findById(1L).ifPresent(u ->
                log.info("[verify] User id=1 active={} (loaded fresh from DB)", u.isActive()));
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Custom repository — dynamic search
    // ─────────────────────────────────────────────────────────────────────────

    @Transactional(readOnly = true)
    public void demoCustomSearch() {
        log.info("─── Custom repository — dynamic search ──────────────────────");

        // Search 1: only active company users with at least 50 logins
        UserSearchCriteria criteria1 = UserSearchCriteria.builder()
                .emailDomain("@company.com")
                .active(true)
                .minLoginCount(50)
                .build();

        List<User> result1 = userRepository.search(criteria1);
        log.info("[Search 1] active @company.com users with ≥50 logins → {} results:", result1.size());
        result1.forEach(u -> log.info("  {} ({}), loginCount={}", u.getUsername(), u.getEmail(), u.getLoginCount()));

        // Search 2: username starts with 'alice' — no other filters
        UserSearchCriteria criteria2 = UserSearchCriteria.builder()
                .usernamePrefix("alice")
                .build();

        List<User> result2 = userRepository.search(criteria2);
        log.info("[Search 2] username starts with 'alice' → {} results:", result2.size());
        result2.forEach(u -> log.info("  {}", u.getUsername()));

        // Search 3: no criteria at all — returns all users
        UserSearchCriteria criteria3 = UserSearchCriteria.builder().build();
        List<User> result3 = userRepository.search(criteria3);
        log.info("[Search 3] no criteria → {} users (all)", result3.size());
    }

    // ─────────────────────────────────────────────────────────────────────────
    // Sorting & Pagination
    // ─────────────────────────────────────────────────────────────────────────

    @Transactional(readOnly = true)
    public void demoPagination() {
        log.info("─── Sorting & Pagination ────────────────────────────────────");

        // PageRequest.of(pageNumber, pageSize, sort)
        // pageNumber is ZERO-BASED: 0 = first page, 1 = second page, etc.
        PageRequest pageRequest = PageRequest.of(
                0,                                       // page index (0 = first)
                3,                                       // 3 users per page
                Sort.by("createdAt").descending()        // newest first
        );

        // findByUsernamePrefixPaged returns a Page<User>
        // Spring fires: the data query + a COUNT(*) query for totalElements
        Page<User> page = userRepository.findByUsernamePrefixPaged("", pageRequest);
        //  "" prefix with LIKE ''% matches all users — acts as "find all" with pagination

        // ── Page metadata ─────────────────────────────────────────────────────
        log.info("[Page metadata]");
        log.info("  totalElements : {} (all matching users)", page.getTotalElements());
        log.info("  totalPages    : {}", page.getTotalPages());
        log.info("  currentPage   : {}", page.getNumber());          // 0-based
        log.info("  pageSize      : {}", page.getSize());
        log.info("  isFirst       : {}", page.isFirst());
        log.info("  isLast        : {}", page.isLast());
        log.info("  hasNext       : {}", page.hasNext());
        log.info("  hasPrevious   : {}", page.hasPrevious());
        log.info("  elements on this page: {}", page.getNumberOfElements());

        log.info("[Page 0 content — 3 users, newest first]:");
        page.getContent().forEach(u ->
                log.info("  {} | active={} | created={}", u.getUsername(), u.isActive(), u.getCreatedAt()));

        // ── Multi-field sort ──────────────────────────────────────────────────
        // Sort.by() can chain multiple fields.
        // Here: sort by active DESC (true before false), then username ASC within each group.
        PageRequest multiSortRequest = PageRequest.of(
                0, 5,
                Sort.by(
                        Sort.Order.desc("active"),        // active users first
                        Sort.Order.asc("username")        // then alphabetically
                )
        );

        // findAll(Pageable) is inherited from JpaRepository
        Page<User> multiSortPage = userRepository.findAll(multiSortRequest);
        log.info("[Multi-sort: active DESC, username ASC — page 0 of size 5]:");
        multiSortPage.getContent().forEach(u ->
                log.info("  {} | active={}", u.getUsername(), u.isActive()));
    }
}
