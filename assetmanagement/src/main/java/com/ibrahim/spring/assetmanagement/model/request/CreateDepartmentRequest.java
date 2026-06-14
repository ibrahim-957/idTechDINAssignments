package com.ibrahim.spring.assetmanagement.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentRequest {
    @NotBlank(message = "{department.name.required}")
    @Size(min = 2, max = 100, message = "{department.name.size}")
    private String name;

    @Size(max = 200, message = "{department.location.size}")
    private String location;
}
