package com.ibrahim.spring.lesson09.task03_data_jpa_repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface L9T2UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Optional<User> findByEmail(String email);

    List<User> findByUsernameContainingIgnoreCase(String keyword);

    List<User> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    List<User> findByActiveTrue();

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u " +
            "WHERE u.username LIKE :prefix% " +
            "ORDER BY u.createdAt DESC")
    List<User> findByUsernamePrefix(String prefix);

    @Query("SELECT u FROM User u " +
            "WHERE u.username LIKE :prefix% " +
            "ORDER BY u.createdAt DESC")
    Page<User> findByUsernamePrefixPaged(String prefix, Pageable pageable);

    @Query(value = "SELECT * FROM l9t3_users ORDER BY login_count DESC LIMIT 5",
            nativeQuery = true)
    List<User> findTop5ByLoginCount();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.active = :active WHERE u.id IN :ids")
    int bulkUpdateActiveStatus(boolean active,
                               List<Long> ids);
}
