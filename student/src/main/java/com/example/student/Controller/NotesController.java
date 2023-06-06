package com.example.student.Controller;

import com.example.student.Service.facade.NotesService;
import com.example.student.model.Notes;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Notes")
@AllArgsConstructor
public class NotesController {
    final NotesService notesService;
    // create new notes
    @PostMapping(value = "/Add")
    public ResponseEntity<?> create(@RequestBody(required = false) Notes notes) throws Exception {
        if(notes == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notes is null");
        Notes savedNotes = notesService.create(notes);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNotes);
    }
    @GetMapping("/{Id}")
    public Optional<Notes> findById(@PathVariable Long Id) throws Exception{
        return notesService.findById(Id);
    }
    @PutMapping("/{id}")
    public Optional<Notes> UpdateC(@PathVariable Long id , @RequestBody Notes updatednotes) throws Exception {
        Optional<Notes> notes =  notesService.findById(id);
        if (notes.isPresent()) {
            Notes existingNotes = notes.get();

            existingNotes.setNote(updatednotes.getNote());

            notesService.create(existingNotes);
        }
        return notes;
    }

    @GetMapping("/")
    public List<Notes> findAll() {
        return notesService.findAll();
    }

    @GetMapping("/Student/{CodeM}")
    public List<Notes> findByStudentCodeM(String CodeM) throws Exception{
        return notesService.findByStudentCodeM(CodeM);
    }

    @GetMapping("/Matiere/{Name}")
    public List<Notes> findByMatiereLabel(String Name) throws Exception{
        return notesService.findByMatiereLabel(Name);
    }
}
