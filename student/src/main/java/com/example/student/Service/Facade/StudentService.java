package com.example.student.Service.Facade;

import com.example.student.Model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student create(Student student) throws Exception;
    Student update(Student student) throws Exception;
    Student findByCodeM(String CodeM) throws Exception;
    List<Student> findAll();
    List<Student> findByClassesName(String name) throws Exception;
    Optional<Student> findStudentByIdWithNotes(String id) throws Exception;
    Boolean DeleteStudent(String id) throws Exception;
}
