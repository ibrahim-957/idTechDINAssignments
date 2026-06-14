package com.ibrahim.spring.assetmanagement.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    @NotBlank(message = "{employee.firstName.required}")
    @Size(min = 2, max = 50, message = "{employee.firstName.size}")
    private String firstName;

    @NotBlank(message = "{employee.lastName.required}")
    @Size(min = 2, max = 50, message = "{employee.lastName.size}")
    private String lastName;

    @NotBlank(message = "{employee.email.required}")
    @Email(message = "{employee.email.invalid}")
    @Size(max = 100, message = "{employee.email.size}")
    private String email;

    @NotNull(message = "{employee.departmentId.required}")
    @Positive(message = "{employee.departmentId.positive}")
    private Long departmentId;
}
