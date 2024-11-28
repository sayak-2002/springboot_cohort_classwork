package com.codingShuttle.springbootweb.springbootweb.dto;


import com.codingShuttle.springbootweb.springbootweb.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    // Validation Annotations
    @NotNull
    @Size(min=3, max=30, message="Number of characters in the name should be in range: [3, 30]")
    @NotBlank(message="Name of the Employee cannot be blank")
    private String name;

    @NotBlank(message="Email of the Employee cannot be blank")
    @Email(message="Email should a valid email.")
    private String email;

    @NotNull(message="Age of the Employee cannot be blank")
    @Min(value=18, message="Age of Employee cannot be less than 18.")
    @Max(value=80, message="Age of Employee cannot be greater than 60")
    private Integer age;

    @NotBlank(message="Role of the Employee cannot be blank.")
//    @Pattern(regexp="^(ADMIN|USER)$", message="Role of Employee can only be USER or ADMIN.")
    @EmployeeRoleValidation  // Custom-Built Validation Annotation
    private String role; // ADMIN, USER

    @PastOrPresent(message="DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @NotNull(message="Salary of the Employee should not null")
    @Positive(message="Salary of the Employee should be positive")
    @Digits(integer=6, fraction=2, message="The salary can be in the the form 00000.00")
    @DecimalMin(value="100.50")
    @DecimalMax(value="999999.99")
    private Double salary;

    @AssertTrue(message="Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
