package com.example.student.Repository;

import com.example.student.model.Notes;
import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Long> {
    public List<Notes> findByStudentCodeM(String CodeM);
    public List<Notes> findByMatiereLabel(String label);
}
