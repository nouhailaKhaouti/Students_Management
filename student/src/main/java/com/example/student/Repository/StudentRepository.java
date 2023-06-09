package com.example.student.Repository;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByCodeM(String codeM);
    public List<Student> findByClassesName(String name);
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.notes WHERE s.id = :id")
    Optional<Student> findStudentByIdWithNotes(@Param("id") Long id);
}
