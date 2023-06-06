package com.example.student.Service.facade;

import com.example.student.exception.Matiere.MatiereNotFoundException;
import com.example.student.model.Matiere;
import com.example.student.model.Matiere;

import java.util.List;
import java.util.Optional;

public interface MatiereService {
    Matiere create(Matiere matiere) throws Exception;
    Matiere update(Matiere matiere) throws Exception;
    Matiere findByName(String Name) throws Exception;
    List<Matiere> findAll();

}
