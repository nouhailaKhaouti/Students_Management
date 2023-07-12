package com.example.student.Repository;

import com.example.student.Model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassesRepository extends JpaRepository<Classes, String> {

    @Query("SELECT c FROM Classes c LEFT JOIN FETCH c.student s WHERE c.name = :name")
    Classes findByName(String name);
}
