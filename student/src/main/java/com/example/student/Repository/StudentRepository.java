package com.example.student.Repository;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByCodeM(String codeM);
    public List<Student> findByClassesName(String name);
}
