package com.ibrahim.spring.assetmanagement.model.request;

import com.ibrahim.spring.assetmanagement.model.enums.AssetCondition;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAssignmentRequest {
    @NotNull(message = "{assignment.assetId.required}")
    @Positive(message = "{assignment.assetId.positive}")
    private Long assetId;

    @NotNull(message = "{assignment.employeeId.required}")
    @Positive(message = "{assignment.employeeId.positive}")
    private Long employeeId;

    @NotNull(message = "{assignment.assignedDate.required}")
    @PastOrPresent(message = "{assignment.assignedDate.pastOrPresent}")
    private LocalDate assignedDate;

    @NotNull(message = "{assignment.condition.required}")
    private AssetCondition condition;

    @Size(max = 500, message = "{assignment.notes.size}")
    private String notes;
}
