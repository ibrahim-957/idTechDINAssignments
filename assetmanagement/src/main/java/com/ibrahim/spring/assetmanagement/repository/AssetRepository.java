package com.ibrahim.spring.assetmanagement.repository;

import com.ibrahim.spring.assetmanagement.entity.Asset;
import com.ibrahim.spring.assetmanagement.model.enums.AssetStatus;
import com.ibrahim.spring.assetmanagement.model.enums.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository
        extends JpaRepository<Asset, Long>, JpaSpecificationExecutor<Asset> {
    boolean existsBySerialNumberIgnoreCase(String serialNumber);

    boolean existsBySerialNumberIgnoreCaseAndIdNot(String serialNumber, Long id);

    Optional<Asset> findBySerialNumberIgnoreCase(String serialNumber);

    List<Asset> findByStatus(AssetStatus status);

    List<Asset> findByType(AssetType type);
}
