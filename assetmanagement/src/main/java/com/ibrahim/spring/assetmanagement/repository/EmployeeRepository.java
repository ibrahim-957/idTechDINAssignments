package com.ibrahim.spring.assetmanagement.repository;

import com.ibrahim.spring.assetmanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    Optional<Employee> findByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);

    List<Employee> findByDepartmentIdAndActiveTrue(Long departmentId);

    @Query("SELECT e FROM Employee e " +
            "JOIN FETCH e.department " +
            "WHERE e.id = :id")
    Optional<Employee> findByIdWithDepartment(Long id);

    @Query("SELECT e FROM Employee e " +
            "WHERE e.id NOT IN " +
            "(SELECT DISTINCT a.employee.id FROM AssetAssignment a)")
    List<Employee> findEmployeesWithNoAssignments();
}
