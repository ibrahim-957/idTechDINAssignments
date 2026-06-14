package com.ibrahim.spring.assetmanagement.model.request;

import com.ibrahim.spring.assetmanagement.model.enums.AssetType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAssetRequest {
    @Size(max = 100)
    private String serialNumber;

    @Size(min = 2, max = 100)
    private String name;

    private AssetType type;

    @DecimalMin(value = "0.01")
    private BigDecimal purchasePrice;

    @PastOrPresent
    private LocalDate purchaseDate;
}
