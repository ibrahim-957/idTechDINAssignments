package com.ibrahim.spring.assetmanagement.repository;

import com.ibrahim.spring.assetmanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByNameIgnoreCase(String name);

    List<Department> findByActiveTrue();

    boolean existsByNameIgnoreCase(String name);

    @Query("SELECT d FROM Department d " +
            "LEFT JOIN FETCH d.employees " +
            "WHERE d.id = :id")
    Optional<Department> findByIdWithEmployees(Long id);
}
