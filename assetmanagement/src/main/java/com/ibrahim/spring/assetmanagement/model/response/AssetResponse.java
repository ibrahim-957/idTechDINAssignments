package com.ibrahim.spring.assetmanagement.model.response;

import com.ibrahim.spring.assetmanagement.model.enums.AssetStatus;
import com.ibrahim.spring.assetmanagement.model.enums.AssetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssetResponse {
    private Long id;
    private String serialNumber;
    private String name;
    private AssetType type;
    private AssetStatus status;
    private BigDecimal purchasePrice;
    private LocalDate purchaseDate;
    private int totalAssignments;
    private LocalDateTime createdAt;
}
