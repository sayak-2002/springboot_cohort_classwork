package com.codingShuttle.springbootweb.springbootweb.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path = "/getSecretMessage")
    public String getMySuperSecretMessage() {
        return "Secret message: asdfal@#$DASD";
    }
}
