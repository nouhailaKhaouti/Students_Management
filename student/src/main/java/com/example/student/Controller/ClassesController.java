package com.example.student.Controller;
import com.example.student.Dto.Classes.ClassesDto;
import com.example.student.Dto.Classes.ClassesGetDto;
import com.example.student.Dto.Classes.ClassesWithOutStudentsListDto;
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
import org.springframework.data.crossstore.ChangeSetPersister;
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
        ClassesWithOutStudentsListDto savedDtoClasses=modelMapper.map(savedClasses, ClassesWithOutStudentsListDto.class);
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
    @GetMapping("/id/{Id}")
    public ResponseEntity<?> findById(@PathVariable String id) throws Exception {
        Optional<Classes> classesOptional = classesService.findById(id);
        Classes classes = classesOptional.orElse(null);

        if (classes == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Classes not found with id: " + id);
        }
        ClassesGetDto classesDto = modelMapper.map(classes, ClassesGetDto.class);

        List<StudentWithOutClassesDto> studentDtos = classes.getStudent().stream()
                .map(student -> modelMapper.map(student, StudentWithOutClassesDto.class))
                .collect(Collectors.toList());

        classesDto.setStudents(studentDtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(classesDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ClassesDto classesDto) throws Exception{
        Classes classes=modelMapper.map(classesDto,Classes.class);
        if(classes == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classes is null");
        }
        Classes savedClasses = classesService.update(classes);
        ClassesGetDto classesGetDto=modelMapper.map(savedClasses,ClassesGetDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(classesGetDto);
    }

    @GetMapping("/")
    public List<ClassesGetDto> findAll() {
        List<Classes> classesList = classesService.findAll();
        Type listType = new TypeToken<List<ClassesGetDto>>() {}.getType();

        List<ClassesGetDto> classesDtoList = modelMapper.map(classesList, listType);
        for (ClassesGetDto classesDto : classesDtoList) {
            List<StudentWithOutClassesDto> studentDtos = classesDto.getStudents().stream()
                    .map(student -> {
                        StudentWithOutClassesDto studentDto = modelMapper.map(student, StudentWithOutClassesDto.class);
                        return studentDto;
                    })
                    .collect(Collectors.toList());
            classesDto.setStudents(studentDtos);
        }

        return classesDtoList;
    }
}
