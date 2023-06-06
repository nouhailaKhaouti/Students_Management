package com.example.student.Service.Impl;

import com.example.student.Repository.NotesRepository;
import com.example.student.Service.facade.NotesService;
import com.example.student.exception.Notes.NotesExistException;
import com.example.student.exception.Notes.NotesNotFoundException;
import com.example.student.model.Notes;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class NotesServiceImpl implements NotesService {

    final NotesRepository notesService;
    @Override
    public Notes create(Notes notes) throws Exception{
        Optional<Notes> notesComingFromDB = notesService.findById(notes.getId());
        if(notesComingFromDB .isPresent()){
            throw new NotesExistException(notes.getId());
        }
        return notesService.save(notes);
    }

    @Override
    public Notes update(Notes notes) throws Exception {
        // check if Notes exists
        Optional<Notes> notesFromDB = notesService.findById(notes.getId());
        if (notesFromDB == null) {
            try {
                throw new NotesNotFoundException(notes.getId());
            } catch (NotesNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return notesService.save(notes);
    }

    @Override
    public Optional<Notes> findById(Long id){
        return notesService.findById(id);
    }

    @Override
    public List<Notes> findAll() {
        return notesService.findAll();
    }

    @Override
    public List<Notes> findByStudentCodeM(String codeM) {
        return notesService.findByStudentCodeM(codeM);
    }

    @Override
    public List<Notes> findByMatiereLabel(String label) {
        return notesService.findByMatiereLabel(label);
    }
}
