package com.ibrahim.spring.assetmanagement.model.request;

import com.ibrahim.spring.assetmanagement.model.enums.AssetType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateAssetRequest {
    @NotBlank(message = "{asset.serialNumber.required}")
    @Size(max = 100, message = "{asset.serialNumber.size}")
    private String serialNumber;

    @NotBlank(message = "{asset.name.required}")
    @Size(min = 2, max = 100, message = "{asset.name.size}")
    private String name;

    @NotNull(message = "{asset.type.required}")
    private AssetType type;

    @NotNull(message = "{asset.purchasePrice.required}")
    @DecimalMin(value = "0.01", message = "{asset.purchasePrice.min}")
    private BigDecimal purchasePrice;

    @NotNull(message = "{asset.purchaseDate.required}")
    @PastOrPresent(message = "{asset.purchaseDate.pastOrPresent}")
    private LocalDate purchaseDate;
}
