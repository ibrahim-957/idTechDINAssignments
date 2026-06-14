package com.ibrahim.spring.assetmanagement.model.request;

import com.ibrahim.spring.assetmanagement.model.enums.AssetCondition;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnAssetRequest {
    @NotNull(message = "{return.returnDate.required}")
    @PastOrPresent(message = "{return.returnDate.pastOrPresent}")
    private LocalDate returnDate;

    @NotNull(message = "{return.condition.required}")
    private AssetCondition condition;

    @Size(max = 500, message = "{return.notes.size}")
    private String notes;
}
