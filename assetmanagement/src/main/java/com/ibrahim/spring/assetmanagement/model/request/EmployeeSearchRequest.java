package com.ibrahim.spring.assetmanagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchRequest {
    private String firstName;
    private String lastName;
    private Long departmentId;
    private Boolean active;
    private int page = 0;
    private int size = 20;
    private String sortBy = "lastName";
    private String sortDir = "asc";
}
