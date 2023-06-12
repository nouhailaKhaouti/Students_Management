package com.example.student.Repository;

import com.example.student.model.Notes;
import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotesRepository extends JpaRepository<Notes, String> {
      List<Notes> findByStudentCodeM(String codeM);
    public List<Notes> findByMatiereLabel(String label);
}
