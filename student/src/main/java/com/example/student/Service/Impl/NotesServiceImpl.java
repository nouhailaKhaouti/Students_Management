package com.example.student.Service.Impl;

import com.example.student.Repository.NotesRepository;
import com.example.student.Service.Facade.NotesService;
import com.example.student.Controller.Exception.Notes.NotesExistException;
import com.example.student.Controller.Exception.Notes.NotesNotFoundException;
import com.example.student.Model.Notes;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class NotesServiceImpl implements NotesService {
    final NotesRepository notesRepository;
    @Override
    public Notes create(Notes notes) throws Exception{
        if (notes.getId() != null) {
            throw new NotesExistException(notes.getId());
        }
        Optional<Notes> notesComingFromDB = notesRepository.findById(notes.getId());
        if(notesComingFromDB .isPresent()){
            throw new NotesExistException(notes.getId());
        }
        notes.setId(UUID.randomUUID().toString());
        return notesRepository.save(notes);
    }

    @Override
    public Notes update(Notes notes) throws Exception {
        // check if Notes exists
        Optional<Notes> notesFromDB = notesRepository.findById(notes.getId());
        if (notesFromDB == null) {
            try {
                throw new NotesNotFoundException(notes.getId());
            } catch (NotesNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return notesRepository.save(notes);
    }

    @Override
    public Optional<Notes> findById(String id){
        return notesRepository.findById(id);
    }

    @Override
    public List<Notes> findAll() {
        return notesRepository.findAll();
    }

    @Override
    public List<Notes> findByStudentCodeM(String codeM) {
        return notesRepository.findByStudentCodeM(codeM);
    }

    @Override
    public List<Notes> findByMatiereLabel(String label) {
        return notesRepository.findByMatiereLabel(label);
    }
}
