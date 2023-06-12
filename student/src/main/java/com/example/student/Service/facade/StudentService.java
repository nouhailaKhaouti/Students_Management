package com.example.student.Service.facade;

import com.example.student.model.Student;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {

    Student create(Student student) throws Exception;
    Student update(Student student) throws Exception;
    Student findByCodeM(String CodeM) throws Exception;
    List<Student> findAll();
    List<Student> findByClassesName(String name) throws Exception;
    Optional<Student> findStudentByIdWithNotes(UUID id) throws Exception;
    Boolean DeleteStudent(UUID id) throws Exception;
}
