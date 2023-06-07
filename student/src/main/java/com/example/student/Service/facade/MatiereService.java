package com.example.student.Service.facade;

import com.example.student.model.Matiere;

import java.util.List;

public interface MatiereService {
    Matiere create(Matiere matiere) throws Exception;
    Matiere update(Matiere matiere) throws Exception;
    Matiere findByName(String Name) throws Exception;
    List<Matiere> findAll();

}
