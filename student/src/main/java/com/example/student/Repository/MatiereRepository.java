package com.example.student.Repository;

import com.example.student.model.Classes;
import com.example.student.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
    Matiere findByLabel(String label);
}
