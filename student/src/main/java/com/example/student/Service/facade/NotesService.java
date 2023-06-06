package com.example.student.Service.facade;

import com.example.student.model.Notes;

import java.util.List;
import java.util.Optional;

public interface NotesService {

    Notes create(Notes note) throws Exception;
    Notes update(Notes note) throws Exception;
    List<Notes> findByStudentCodeM(String CodeM) throws Exception;
    List<Notes> findByMatiereLabel(String label) throws Exception;
    Optional<Notes> findById(Long Id) throws Exception;
    List<Notes> findAll();
}
