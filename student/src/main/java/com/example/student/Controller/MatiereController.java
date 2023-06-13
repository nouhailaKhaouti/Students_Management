package com.example.student.Controller;

import com.example.student.Dto.Classes.ClassesDto;
import com.example.student.Dto.Classes.ClassesGetDto;
import com.example.student.Dto.Matiere.MatiereDto;
import com.example.student.Dto.Matiere.MatiereGetDto;
import com.example.student.Dto.Matiere.MatiereWithNotesDto;
import com.example.student.Dto.Notes.NotesGetWithStudentDto;
import com.example.student.Dto.Student.StudentWithOutClassesDto;
import com.example.student.Service.facade.MatiereService;
import com.example.student.model.Classes;
import com.example.student.model.Matiere;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Matiere")
@AllArgsConstructor
public class MatiereController {

    @Autowired
    final ModelMapper modelMapper;

    final MatiereService matiereService;

    // create new matiere
    @PostMapping(value = "/Add")
    public ResponseEntity<?> create(@RequestBody() MatiereDto matiereDto) throws Exception {
        Matiere matiere=modelMapper.map(matiereDto,Matiere.class);
        if(matiere == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Matiere is null");
        Matiere savedMatiere = matiereService.create(matiere);
        MatiereGetDto matiereS=modelMapper.map(savedMatiere,MatiereGetDto.class);
        System.out.print(matiereS);
        return ResponseEntity.status(HttpStatus.CREATED).body(matiereS);
    }

    @GetMapping("/{Name}")
    public MatiereWithNotesDto findByName(@PathVariable String Name) throws Exception{
        Matiere matiere= matiereService.findByName(Name);
        MatiereWithNotesDto matiereDto = modelMapper.map(matiere, MatiereWithNotesDto.class);
        List<NotesGetWithStudentDto> notesDtos = matiere.getNotes().stream()
                .map(notes -> {
                    NotesGetWithStudentDto notesDto = modelMapper.map(notes, NotesGetWithStudentDto.class);
                    return notesDto;
                })
                .collect(Collectors.toList());
        matiereDto.setNotes(notesDtos);
        return matiereDto;
    }
    @PutMapping("/{name}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody MatiereDto matiereDto) throws Exception{
        Matiere matiere=modelMapper.map(matiereDto,Matiere.class);
        if(matiere == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classes is null");
        }
        Matiere savedMatiere = matiereService.update(matiere);
        MatiereGetDto matiereGetDto=modelMapper.map(savedMatiere,MatiereGetDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(matiereGetDto);
    }

    @GetMapping("/")
    public List<MatiereWithNotesDto> findAll() {
        List<Matiere> matiereList = matiereService.findAll();
        Type listType = new TypeToken<List<MatiereGetDto>>() {}.getType();
        List<MatiereWithNotesDto> matiereDtoList = modelMapper.map(matiereList, listType);
        for (MatiereWithNotesDto matiereDto : matiereDtoList) {
            List<NotesGetWithStudentDto> notesDtos = matiereDto.getNotes().stream()
                    .map(notes -> {
                        NotesGetWithStudentDto notesDto = modelMapper.map(notes, NotesGetWithStudentDto.class);
                        return notesDto;
                    })
                    .collect(Collectors.toList());
            matiereDto.setNotes(notesDtos);
        }
        return matiereDtoList;
    }
}
