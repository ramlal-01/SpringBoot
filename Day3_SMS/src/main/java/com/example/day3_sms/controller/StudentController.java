package com.example.day3_sms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping
    public String index() {
        return "Home Page for Students .";
    }
}
