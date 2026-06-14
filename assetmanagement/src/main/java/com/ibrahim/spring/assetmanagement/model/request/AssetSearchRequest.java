package com.ibrahim.spring.assetmanagement.model.request;

import com.ibrahim.spring.assetmanagement.model.enums.AssetStatus;
import com.ibrahim.spring.assetmanagement.model.enums.AssetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetSearchRequest {
    private String name;
    private String serialNumber;
    private AssetType type;
    private AssetStatus status;
    private int page = 0;
    private int size = 20;
    private String sortBy = "name";
    private String sortDir = "asc";
}
