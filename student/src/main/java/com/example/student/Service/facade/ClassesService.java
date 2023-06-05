package com.example.student.Service.facade;

import com.example.student.model.Classes;
import com.example.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface ClassesService {

    Classes create(Classes classes) throws Exception;
    Classes update(Classes classes) throws Exception;
    Classes findByName(String Name) throws Exception;
    List<Classes> findAll();

    Optional<Classes> classesbyId(Long id);
}
