package com.ibrahim.simpleshop.dao.repository;

import com.ibrahim.simpleshop.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Page<User> findAll(Pageable pageable);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
