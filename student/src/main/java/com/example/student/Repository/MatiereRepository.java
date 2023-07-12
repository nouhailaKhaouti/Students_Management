package com.example.student.Repository;

import com.example.student.Model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere, String> {
    Matiere findByLabel(String label);
}
