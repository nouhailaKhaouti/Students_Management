package com.example.student.Service.Facade;

import com.example.student.Model.Matiere;

import java.util.List;

public interface IMatiereService {
    Matiere create(Matiere matiere) throws Exception;
    Matiere update(Matiere matiere) throws Exception;
    Matiere findByName(String Name) throws Exception;
    List<Matiere> findAll();

}
