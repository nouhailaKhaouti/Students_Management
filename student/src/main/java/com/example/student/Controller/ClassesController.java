package com.example.student.Controller;
import com.example.student.Dto.ClassesDto;
import com.example.student.Dto.ClassesGetDto;
import com.example.student.Service.facade.ClassesService;
import com.example.student.model.Classes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
@Slf4j
public class ClassesController {

    @Autowired
    private ModelMapper modelMapper;
    final ClassesService classesService;

    // create new classes
    @PostMapping (value = "/Add")
    public ResponseEntity<?> create(@RequestBody() ClassesDto classesDto) throws Exception {
        Classes classes = modelMapper.map(classesDto, Classes.class);
        if(classes == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classes is null");
        Classes savedClasses = classesService.create(classes);
        ClassesDto savedDtoClasses=modelMapper.map(savedClasses, ClassesDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDtoClasses);
    }

    @GetMapping("/{Name}")
    public ClassesGetDto findByName(@PathVariable String Name) throws Exception{
        return modelMapper.map(classesService.findByName(Name), ClassesGetDto.class);
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
    public List<ClassesGetDto> findAll() {
        List<Classes> classesList = classesService.findAll();
        Type listType = new TypeToken<List<ClassesGetDto>>() {}.getType();
        return modelMapper.map(classesList, listType);
    }
}
