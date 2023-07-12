package com.example.student.Service.Facade;

import com.example.student.Model.Classes;

import java.util.List;
import java.util.Optional;

public interface IClassesService {

    Classes create(Classes classes) throws Exception;
    Classes update(Classes classes) throws Exception;
    Classes findByName(String Name) throws Exception;
    Optional<Classes> findById(String id) throws Exception;
    List<Classes> findAll();

}
