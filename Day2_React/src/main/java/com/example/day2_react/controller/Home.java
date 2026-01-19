package com.example.day2_react.controller;

import com.example.day2_react.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Home {

    @GetMapping

    public StudentModel getStudent() {
        StudentModel student = new StudentModel(1, "Ram" , "ram@gmail.com");

        return student;
    }

    @GetMapping("/userdata")
    public ArrayList<StudentModel> getStudents() {
        ArrayList<StudentModel> students = new ArrayList<>();
        students.add(new StudentModel(1, "John", "Doe"));
        students.add(new StudentModel(2, "Aditya", "adi@gmail.com"));
        students.add(new StudentModel(3, "Ram", "ram@gmail.com"));
        students.add(new StudentModel(4, "Remanshu", "remanshu@gmail.com"));
        students.add(new StudentModel(5, "Aman", "Aman@gmail.com"));

        return students;
    }
}
