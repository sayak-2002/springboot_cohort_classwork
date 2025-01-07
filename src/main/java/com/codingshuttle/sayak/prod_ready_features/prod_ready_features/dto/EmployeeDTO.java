package com.codingshuttle.sayak.prod_ready_features.prod_ready_features.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {

    private Long id;

    private String name;

    private String email;

    private Integer age;

    private String role; // ADMIN, USER

    private LocalDate dateOfJoining;

    private Double salary;

    private Boolean isActive;
}
