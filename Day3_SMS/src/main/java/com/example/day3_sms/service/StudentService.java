package com.example.day3_sms.service;

import com.example.day3_sms.model.StudentModel;
import com.example.day3_sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository Repository) {
        this.repository = Repository;
    }

    public StudentModel addStudent(StudentModel student) {
        return repository.save(student);
    }
}
