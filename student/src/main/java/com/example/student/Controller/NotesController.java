package com.example.student.Controller;

import com.example.student.Dto.Classes.ClassesGetDto;
import com.example.student.Dto.Notes.NotesDto;
import com.example.student.Dto.Notes.NotesGetWithStudentDto;
import com.example.student.Service.facade.NotesService;
import com.example.student.model.Classes;
import com.example.student.model.Notes;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Notes")
@AllArgsConstructor
public class NotesController {
    @Autowired
    final ModelMapper modelMapper;
    final NotesService notesService;
    // create new notes
    @PostMapping(value = "/Add")
    public ResponseEntity<?> create(@RequestBody() NotesDto notesDto) throws Exception {
        Notes notes= modelMapper.map(notesDto, Notes.class);
        if(notes == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notes is null");
        Notes savedNotes = notesService.create(notes);
        NotesGetWithStudentDto notesS= modelMapper.map(savedNotes,NotesGetWithStudentDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(notesS);
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
    public List<NotesGetWithStudentDto> findAll() {
        List<Notes> notesList = notesService.findAll();
        Type listType = new TypeToken<List<NotesGetWithStudentDto>>() {}.getType();
        return modelMapper.map(notesList, listType);
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
