package com.example.student.Controller;

import com.example.student.Convert.StudentConvert;
import com.example.student.Dto.StudentDto;
import com.example.student.Service.facade.ClassesService;
import com.example.student.Service.facade.StudentService;
import com.example.student.model.Classes;
import com.example.student.model.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Slf4j
public class StudentController {
    final StudentService studentService;
    final ClassesService classesService;
    final StudentConvert studentConvert;
    // create new student
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody(required = false) StudentDto studentDTO) throws Exception {
        System.out.println("Student save here .... ");
        if(studentDTO == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student is null");
        Student student = studentConvert.convertDtoToEntity(studentDTO);
        Student savedStudent = studentService.update(student);
        StudentDto studentS = studentConvert.convertEntityToDto(savedStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentS);
    }

    @GetMapping("/{CodeM}")
    public StudentDto findByCodeM(@PathVariable String CodeM) throws Exception{
        Student student =studentService.findByCodeM(CodeM);
        StudentDto studentS = studentConvert.convertEntityToDto(student);
        return studentS;
    }

    @PutMapping("/{CodeM}")
    public ResponseEntity<?> update(@PathVariable String CodeM, @RequestBody StudentDto studentDTO) throws Exception{
        if(studentDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student is null");
        }
        Student student = studentConvert.convertDtoToEntity(studentDTO);
        Student savedStudent = studentService.update(student);
        StudentDto studentS = studentConvert.convertEntityToDto(savedStudent);
        return ResponseEntity.status(HttpStatus.OK).body(studentS);
    }

    @GetMapping("/")
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
