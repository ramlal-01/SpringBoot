package com.example.day2_react.controller;

import com.example.day2_react.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping

    public StudentModel getStudent() {
        StudentModel student = new StudentModel(1, "Ram" , "ram@gmail.com");

        return student;
    }
}
