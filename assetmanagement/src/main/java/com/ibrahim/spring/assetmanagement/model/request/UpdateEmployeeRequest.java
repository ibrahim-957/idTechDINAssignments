package com.ibrahim.spring.assetmanagement.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
    @Size(min = 2, max = 50, message = "{employee.firstName.size}")
    private String firstName;

    @Size(min = 2, max = 50, message = "{employee.lastName.Size}")
    private String lastName;

    @Email(message = "{employee.email.invalid}")
    @Size(max = 100, message = "{employee.email.size}")
    private String email;

    @Positive(message = "{employee.departmentId.positive}")
    private Long departmentId;
}
