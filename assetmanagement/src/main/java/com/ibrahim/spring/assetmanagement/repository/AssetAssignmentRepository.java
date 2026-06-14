package com.ibrahim.spring.assetmanagement.repository;

import com.ibrahim.spring.assetmanagement.entity.AssetAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AssetAssignmentRepository extends JpaRepository<AssetAssignment, Long> {
    @Query("SELECT a FROM AssetAssignment a " +
            "JOIN FETCH a.asset " +
            "JOIN FETCH a.employee " +
            "WHERE a.employee.id = :employeeId AND a.returnDate IS NULL")
    List<AssetAssignment> findActiveByEmployeeId(Long employeeId);

    @Query("SELECT a FROM AssetAssignment a " +
            "JOIN FETCH a.asset " +
            "JOIN FETCH a.employee " +
            "WHERE a.asset.id = :assetId")
    List<AssetAssignment> findAllByAssetId(Long assetId);

    @Query("SELECT a FROM AssetAssignment a " +
            "JOIN FETCH a.asset " +
            "JOIN FETCH a.employee " +
            "WHERE a.id = :id")
    Optional<AssetAssignment> findByIdWithDetails(Long id);

    boolean existsByAssetIdAndReturnDateIsNull(Long assetId);
}
