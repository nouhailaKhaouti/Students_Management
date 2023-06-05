package com.example.student.Service.facade;

import com.example.student.model.Classes;

import java.util.List;

public interface ClassesService {

    Classes create(Classes classes) throws Exception;
    Classes update(Classes classes) throws Exception;
    Classes findByName(String name) throws Exception;
    List<Classes> findAll();
}
