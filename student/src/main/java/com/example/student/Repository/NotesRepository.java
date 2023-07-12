package com.example.student.Repository;

import com.example.student.Model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, String> {
      List<Notes> findByStudentCodeM(String codeM);
    public List<Notes> findByMatiereLabel(String label);
}
