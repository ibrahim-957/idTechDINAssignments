package com.ibrahim.spring.assetmanagement.service;

import com.ibrahim.spring.assetmanagement.model.request.AssetSearchRequest;
import com.ibrahim.spring.assetmanagement.model.request.CreateAssetRequest;
import com.ibrahim.spring.assetmanagement.model.request.UpdateAssetRequest;
import com.ibrahim.spring.assetmanagement.model.response.AssetResponse;
import com.ibrahim.spring.assetmanagement.model.response.common.PageResponse;

public interface AssetService {
    PageResponse<AssetResponse> search(AssetSearchRequest request);

    AssetResponse findById(Long id);

    AssetResponse create(CreateAssetRequest request);

    AssetResponse update(Long id, UpdateAssetRequest request);

    void retire(Long id);
}
