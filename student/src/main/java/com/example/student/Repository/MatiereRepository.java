package com.example.student.Repository;

import com.example.student.model.Classes;
import com.example.student.model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatiereRepository extends JpaRepository<Matiere, String> {
    Matiere findByLabel(String label);
}
