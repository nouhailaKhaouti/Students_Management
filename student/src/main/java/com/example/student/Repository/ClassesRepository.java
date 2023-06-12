package com.example.student.Repository;

import com.example.student.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ClassesRepository extends JpaRepository<Classes, UUID> {

    @Query("SELECT c FROM Classes c LEFT JOIN FETCH c.student s WHERE c.name = :name")
    Classes findByName(String name);
}
