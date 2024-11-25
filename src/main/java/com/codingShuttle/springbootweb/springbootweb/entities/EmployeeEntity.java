package com.codingShuttle.springbootweb.springbootweb.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity  // It will tell the spring data JPA, to convert this class into table inside the database
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id    // Primary key
    @GeneratedValue(strategy = GenerationType.AUTO)   // Auto-generated
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

}
