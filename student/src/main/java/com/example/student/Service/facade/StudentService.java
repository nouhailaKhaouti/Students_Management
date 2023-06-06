package com.example.student.Service.facade;

import com.example.student.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student create(Student student) throws Exception;
    Student update(Student student) throws Exception;
    Student findByCodeM(String CodeM) throws Exception;
    List<Student> findAll();
    List<Student> findByClassesName(String name) throws Exception;
    Optional<Student> findStudentByIdWithNotes(Long id) throws Exception;
    Boolean DeleteStudent(Long id) throws Exception;
}
