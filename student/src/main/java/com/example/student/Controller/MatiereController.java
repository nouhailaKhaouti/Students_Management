package com.example.student.Controller;

import com.example.student.Service.facade.MatiereService;
import com.example.student.model.Matiere;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Matiere")
@AllArgsConstructor
public class MatiereController {


    final MatiereService matiereService;

    // create new matiere
    @PostMapping(value = "/Add")
    public ResponseEntity<?> create(@RequestBody(required = false) Matiere matiere) throws Exception {
        if(matiere == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Matiere is null");
        Matiere savedMatiere = matiereService.create(matiere);
        return ResponseEntity.status(HttpStatus.CREATED).body(matiere);
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
        return matiereService.findAll();
    }
}
