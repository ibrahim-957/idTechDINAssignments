package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.model.request.CreateAssignmentRequest;
import com.ibrahim.spring.assetmanagement.model.request.ReturnAssetRequest;
import com.ibrahim.spring.assetmanagement.model.response.AssetAssignmentResponse;

import java.util.List;

public interface AssetAssignmentService {
    AssetAssignmentResponse assign(CreateAssignmentRequest request);
    AssetAssignmentResponse returnAsset(Long assignmentId, ReturnAssetRequest request);
    List<AssetAssignmentResponse> findActiveByEmployee(Long employeeId);
    List<AssetAssignmentResponse> findByAsset(Long assetId);
    AssetAssignmentResponse findById(Long id);
}
