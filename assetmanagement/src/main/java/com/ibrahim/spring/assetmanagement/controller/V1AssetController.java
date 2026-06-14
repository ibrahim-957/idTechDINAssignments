package com.ibrahim.spring.assetmanagement.controller;

import com.ibrahim.spring.assetmanagement.model.enums.AssetStatus;
import com.ibrahim.spring.assetmanagement.model.enums.AssetType;
import com.ibrahim.spring.assetmanagement.model.request.AssetSearchRequest;
import com.ibrahim.spring.assetmanagement.model.request.CreateAssetRequest;
import com.ibrahim.spring.assetmanagement.model.request.UpdateAssetRequest;
import com.ibrahim.spring.assetmanagement.model.response.AssetResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.ApiResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.PageResponse;
import com.ibrahim.spring.assetmanagement.service.AssetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assets")
@RequiredArgsConstructor
@Validated
public class V1AssetController {
    private final AssetService assetService;

    @PostMapping
    public ResponseEntity<ApiResponse<AssetResponse>> create(
            @Valid @RequestBody CreateAssetRequest request) {
        AssetResponse response = assetService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Asset created successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<AssetResponse>>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String serialNumber,
            @RequestParam(required = false) AssetType type,
            @RequestParam(required = false) AssetStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {

        AssetSearchRequest request = new AssetSearchRequest(
                name, serialNumber, type, status, page, size, sortBy, sortDir);

        return ResponseEntity.ok(ApiResponse.success(assetService.search(request)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AssetResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(assetService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AssetResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateAssetRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(assetService.update(id, request), "Asset updated successfully"));
    }

    @DeleteMapping("/{id}/retire")
    public ResponseEntity<ApiResponse<Void>> retire(@PathVariable Long id) {
        assetService.retire(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Asset retired successfully"));
    }
}
