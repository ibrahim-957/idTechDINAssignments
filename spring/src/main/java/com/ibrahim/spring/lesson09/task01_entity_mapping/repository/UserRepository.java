package com.ibrahim.spring.lesson09.task01_entity_mapping.repository;

import com.ibrahim.spring.lesson09.task01_entity_mapping.UserStatus;
import com.ibrahim.spring.lesson09.task01_entity_mapping.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findByStatus(UserStatus status);
}
