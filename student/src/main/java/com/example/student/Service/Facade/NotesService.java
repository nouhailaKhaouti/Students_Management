package com.example.student.Service.Facade;

import com.example.student.Model.Notes;

import java.util.List;
import java.util.Optional;

public interface NotesService {

    Notes create(Notes note) throws Exception;
    Notes update(Notes note) throws Exception;
    List<Notes> findByStudentCodeM(String CodeM) throws Exception;
    List<Notes> findByMatiereLabel(String label) throws Exception;
    Optional<Notes> findById(String Id) throws Exception;
    List<Notes> findAll();
}
