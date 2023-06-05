package com.example.student.Controller;
import com.example.student.Service.facade.ClassesService;
import com.example.student.exception.Classes.ClassesExistException;
import com.example.student.model.Classes;
import com.example.student.model.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
@Slf4j
public class ClassesController {

    final ClassesService classesService;

    // create new classes
    @PostMapping (value = "/Add")
    public ResponseEntity<?> create(@RequestBody(required = false) Classes classes) throws Exception {
        if(classes == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classes is null");
        Classes savedClasses = classesService.create(classes);
        return ResponseEntity.status(HttpStatus.CREATED).body(classes);
    }

    @GetMapping("/{Name}")
    public Classes findByName(@PathVariable String Name) throws Exception{
        return classesService.findByName(Name);
    }
    @PutMapping("/{id}")
    public Optional<Classes> UpdateC(@PathVariable Long id , @RequestBody Classes updatedclasses) throws Exception {
        Optional<Classes> classes =  classesService.classesbyId(id);
        if (classes.isPresent()) {
            Classes existingClasses = classes.get();

            existingClasses.setName(updatedclasses.getName());
            existingClasses.setNumberS(updatedclasses.getNumberS());

            classesService.create(existingClasses);
        }
        return classes;
    }
//    public ResponseEntity<?> update(@PathVariable String Name, @RequestBody Classes classes) throws Exception{
//        if(classes == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classes is null");
//        }
//        Classes savedClasses = classesService.update(classes);
//        return ResponseEntity.status(HttpStatus.OK).body(classes);
//
//    }

    @GetMapping("/")
    public List<Classes> findAll() {
        return classesService.findAll();
    }
}
