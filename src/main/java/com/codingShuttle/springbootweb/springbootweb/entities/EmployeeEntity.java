package com.codingShuttle.springbootweb.springbootweb.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity  // It will tell the spring data JPA, to convert this class into table inside the database

// lombok dependency handles all getter and setter methods and constructor
@Getter
@Setter
@AllArgsConstructor   // generates a constructor with all the parameters as arguments
@NoArgsConstructor    // generates a constructor with no parameters
@Table(name = "employees")
public class EmployeeEntity {

    @Id    // Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)   // Auto-generated
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;
    private String role;
    private Double salary;

}
