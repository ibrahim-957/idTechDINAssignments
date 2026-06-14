package com.ibrahim.spring.assetmanagement.model.response;

import com.ibrahim.spring.assetmanagement.model.enums.AssetCondition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetAssignmentResponse {
    private Long id;
    private Long assetId;
    private String assetName;
    private String assetSerialNumber;
    private Long employeeId;
    private String employeeFullName;
    private LocalDate assignedDate;
    private LocalDate returnDate;
    private AssetCondition condition;
    private String notes;
    private boolean active;
    private LocalDateTime createdAt;
}
