package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.entity.Asset;
import com.ibrahim.spring.assetmanagement.exception.BusinessException;
import com.ibrahim.spring.assetmanagement.exception.NotFoundException;
import com.ibrahim.spring.assetmanagement.mapper.AssetMapper;
import com.ibrahim.spring.assetmanagement.model.enums.AssetStatus;
import com.ibrahim.spring.assetmanagement.model.request.AssetSearchRequest;
import com.ibrahim.spring.assetmanagement.model.request.CreateAssetRequest;
import com.ibrahim.spring.assetmanagement.model.request.UpdateAssetRequest;
import com.ibrahim.spring.assetmanagement.model.response.AssetResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.PageResponse;
import com.ibrahim.spring.assetmanagement.repository.AssetRepository;
import com.ibrahim.spring.assetmanagement.specification.AssetSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssetServiceImpl implements AssetService {
    private static final Set<String> ALLOWED_SORT_FIELDS =
            Set.of("name", "type", "status", "purchaseDate", "purchasePrice", "serialNumber");

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Override
    public PageResponse<AssetResponse> search(AssetSearchRequest request) {
        String sortBy = ALLOWED_SORT_FIELDS.contains(request.getSortBy())
                ? request.getSortBy() : "name";

        Sort sort = "desc".equalsIgnoreCase(request.getSortDir())
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);

        Specification<Asset> spec = Specification
                .where(AssetSpecification.hasName(request.getName()))
                .and(AssetSpecification.hasSerialNumber(request.getSerialNumber()))
                .and(AssetSpecification.hasType(request.getType()))
                .and(AssetSpecification.hasStatus(request.getStatus()));

        Page<AssetResponse> page = assetRepository
                .findAll(spec, pageable)
                .map(assetMapper::toResponse);

        return PageResponse.from(page);
    }

    @Override
    public AssetResponse findById(Long id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Asset", id));
        return assetMapper.toResponse(asset);
    }

    @Override
    @Transactional
    public AssetResponse create(CreateAssetRequest request) {
        if (assetRepository.existsBySerialNumberIgnoreCase(request.getSerialNumber())) {
            throw new BusinessException(
                    "Asset with serial number " + request.getSerialNumber() + " already exists"
            );
        }

        Asset asset = assetMapper.toEntity(request);
        Asset saved = assetRepository.save(asset);
        log.info("Created Asset with serial number {}", saved.getSerialNumber());
        return assetMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public AssetResponse update(Long id, UpdateAssetRequest request) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Asset", id));

        if (request.getSerialNumber() != null &&
        assetRepository.existsBySerialNumberIgnoreCaseAndIdNot(request.getSerialNumber(), id)) {
            throw new BusinessException(
                    "Serial number in use: " + request.getSerialNumber());
        }

        assetMapper.updateEntity(request, asset);
        log.info("Updated Asset with serial number {}", asset.getSerialNumber());
        return assetMapper.toResponse(asset);
    }

    @Override
    @Transactional
    public void retire(Long id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Asset", id));
        if (asset.getStatus() == AssetStatus.ASSIGNED){
            throw new BusinessException(
                    "Cannot retire asset that is currently assigned. Return it first"
            );
        }

        asset.setStatus(AssetStatus.RETIRED);
        log.info("Retired Asset with serial number {}", asset.getSerialNumber());
    }
}
