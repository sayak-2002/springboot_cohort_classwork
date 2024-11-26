package com.codingShuttle.springbootweb.springbootweb.controllers;


import com.codingShuttle.springbootweb.springbootweb.dto.EmployeeDTO;
import com.codingShuttle.springbootweb.springbootweb.entities.EmployeeEntity;
import com.codingShuttle.springbootweb.springbootweb.repositories.EmployeeRepository;
import com.codingShuttle.springbootweb.springbootweb.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")     // replaced by RequestMapping
//    public String getMySuperSecretMessage() {
//        return "Secret message: asdfal@#$DASD";
//    }

    private final EmployeeService employeeService;

    // Constructor Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeId") Long Id) {   // @PathVariable is for importing teh path from @GetMapping
        return employeeService.getEmployeeById(Id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping String updateEmployeeById() {
        return "Hello from PUT";
    }

}
