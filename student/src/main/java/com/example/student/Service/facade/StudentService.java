package com.example.student.Service.facade;

import com.example.student.model.Student;
import java.util.List;

public interface StudentService {

    Student create(Student student) throws Exception;
    Student update(Student student) throws Exception;
    Student findByCodeM(String CodeM) throws Exception;
    List<Student> findAll();
}
