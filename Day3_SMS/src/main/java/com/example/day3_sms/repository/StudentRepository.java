package com.example.day3_sms.repository;

import com.example.day3_sms.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository <StudentModel,String> {

}
