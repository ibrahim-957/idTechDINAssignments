package com.ibrahim.spring.assetmanagement.controller;

import com.ibrahim.spring.assetmanagement.model.request.CreateAssignmentRequest;
import com.ibrahim.spring.assetmanagement.model.request.ReturnAssetRequest;
import com.ibrahim.spring.assetmanagement.model.response.AssetAssignmentResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.ApiResponse;
import com.ibrahim.spring.assetmanagement.service.AssetAssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignments")
@RequiredArgsConstructor
@Validated
public class V1AssetAssignmentController {
    private final AssetAssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<AssetAssignmentResponse>> assign(
            @Valid @RequestBody CreateAssignmentRequest request) {
        AssetAssignmentResponse response = assignmentService.assign(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Asset assigned successfully"));
    }

    @PatchMapping("/{id}/return")
    public ResponseEntity<ApiResponse<AssetAssignmentResponse>> returnAsset(
            @PathVariable Long id,
            @Valid @RequestBody ReturnAssetRequest request) {
        return ResponseEntity.ok(
                ApiResponse.success(
                        assignmentService.returnAsset(id, request),
                        "Asset returned successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AssetAssignmentResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(assignmentService.findById(id)));
    }

    @GetMapping("/employee/{employeeId}/active")
    public ResponseEntity<ApiResponse<List<AssetAssignmentResponse>>> findActiveByEmployee(
            @PathVariable Long employeeId) {
        return ResponseEntity.ok(
                ApiResponse.success(assignmentService.findActiveByEmployee(employeeId)));
    }

    @GetMapping("/asset/{assetId}")
    public ResponseEntity<ApiResponse<List<AssetAssignmentResponse>>> findByAsset(
            @PathVariable Long assetId) {
        return ResponseEntity.ok(
                ApiResponse.success(assignmentService.findByAsset(assetId)));
    }
}
