package com.codingShuttle.springbootweb.springbootweb.controllers;


import com.codingShuttle.springbootweb.springbootweb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage() {
//        return "Secret message: asdfal@#$DASD";
//    }

    @GetMapping()
    public String getEmployeeByID() {
        return "Employee 1";
    }
}
