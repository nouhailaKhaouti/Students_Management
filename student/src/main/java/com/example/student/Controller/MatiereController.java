package com.example.student.Controller;

import com.example.student.Dto.Matiere.MatiereDto;
import com.example.student.Dto.Matiere.MatiereGetDto;
import com.example.student.Dto.Notes.NotesGetWithStudentDto;
import com.example.student.Service.facade.MatiereService;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(matiereS);
    }

    @GetMapping("/{Name}")
    public Matiere findByName(@PathVariable String Name) throws Exception{
        return matiereService.findByName(Name);
    }
    @PutMapping("/{name}")
    public Matiere UpdateC(@PathVariable String name , @RequestBody Matiere updatedmatiere) throws Exception {
        Matiere matiere =  matiereService.findByName(name);
        if (matiere!=null) {
            Matiere existingMatiere = matiere;

            existingMatiere.setLabel(updatedmatiere.getLabel());

            matiereService.create(existingMatiere);
        }
        return matiere;
    }

    @GetMapping("/")
    public List<Matiere> findAll() {
        List<Matiere> matiereList = matiereService.findAll();
        Type listType = new TypeToken<List<MatiereGetDto>>() {}.getType();
        return modelMapper.map(matiereList, listType);
    }
}
