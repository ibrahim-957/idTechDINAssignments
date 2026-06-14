package com.ibrahim.spring.assetmanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String fullName;
    private Long departmentId;
    private String departmentName;
    private boolean active;
    private int activeAssignmentCount;
    private LocalDateTime createdAt;
}
