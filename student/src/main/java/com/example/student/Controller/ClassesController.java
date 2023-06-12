package com.example.student.Controller;
import com.example.student.Dto.Classes.ClassesDto;
import com.example.student.Dto.Classes.ClassesGetDto;
import com.example.student.Dto.Student.StudentGetDto;
import com.example.student.Dto.Student.StudentWithOutClassesDto;
import com.example.student.Service.facade.ClassesService;
import com.example.student.model.Classes;
import com.example.student.model.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
@Slf4j
public class ClassesController {

    final ClassesService classesService;
    final ModelMapper modelMapper;
    // create new classes
    @PostMapping (value = "/Add")
    public ResponseEntity<?> create(@RequestBody() ClassesDto classesDto) throws Exception {
        Classes classes = modelMapper.map(classesDto, Classes.class);
        if(classes == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classes is null");
        Classes savedClasses = classesService.create(classes);
        ClassesGetDto savedDtoClasses=modelMapper.map(savedClasses, ClassesGetDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDtoClasses);
    }

    @GetMapping("/{Name}")
    public ClassesGetDto findByName(@PathVariable String Name) throws Exception {
        Classes classes = classesService.findByName(Name);
        ClassesGetDto classesDto = modelMapper.map(classes, ClassesGetDto.class);
        List<StudentWithOutClassesDto> studentDtos = classes.getStudent().stream()
                .map(student -> {
                    StudentWithOutClassesDto studentDto = modelMapper.map(student, StudentWithOutClassesDto.class);
                    return studentDto;
                })
                .collect(Collectors.toList());
        classesDto.setStudents(studentDtos);
        return classesDto;
    }
    @PutMapping("/{id}")
    public Optional<Classes> UpdateC(@PathVariable UUID id , @RequestBody Classes updatedclasses) throws Exception {
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
