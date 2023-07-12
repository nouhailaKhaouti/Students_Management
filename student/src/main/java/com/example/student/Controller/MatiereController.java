package com.example.student.Controller;

import com.example.student.Dto.Matiere.MatiereDto;
import com.example.student.Dto.Matiere.MatiereGetDto;
import com.example.student.Dto.Matiere.MatiereWithNotesDto;
import com.example.student.Dto.Notes.NotesGetWithStudentDto;
import com.example.student.Service.Facade.IMatiereService;
import com.example.student.Model.Matiere;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Matiere")
@AllArgsConstructor
public class MatiereController {
    final ModelMapper modelMapper;
    final IMatiereService IMatiereService;
    @PostMapping(value = "/Add")
    public ResponseEntity<?> create(@RequestBody() MatiereDto matiereDto) throws Exception {
        Matiere matiere=modelMapper.map(matiereDto,Matiere.class);
        if(matiere == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Matiere is null");
        Matiere savedMatiere = IMatiereService.create(matiere);
        MatiereGetDto matiereS=modelMapper.map(savedMatiere,MatiereGetDto.class);
        System.out.print(matiereS);
        return ResponseEntity.status(HttpStatus.CREATED).body(matiereS);
    }

    @GetMapping("/{Name}")
    public MatiereWithNotesDto findByName(@PathVariable String Name) throws Exception{
        Matiere matiere= IMatiereService.findByName(Name);
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
        Matiere savedMatiere = IMatiereService.update(matiere);
        MatiereGetDto matiereGetDto=modelMapper.map(savedMatiere,MatiereGetDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(matiereGetDto);
    }

    @GetMapping("/")
    public List<MatiereWithNotesDto> findAll() {
        List<Matiere> matiereList = IMatiereService.findAll();
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
