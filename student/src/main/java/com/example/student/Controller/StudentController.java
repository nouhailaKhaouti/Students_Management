package com.example.student.Controller;

import com.example.student.Service.facade.StudentService;
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

    // create new student
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody(required = false) Student student) throws Exception {
        if(student == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student is null");
        Student savedStudent = studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("/{CodeM}")
    public Student findByCodeM(@PathVariable String CodeM) throws Exception{
        return studentService.findByCodeM(CodeM);
    }

    @PutMapping("/{CodeM}")
    public ResponseEntity<?> update(@PathVariable String CodeM, @RequestBody Student student) throws Exception{
        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student is null");
        }
        Student savedStudent = studentService.update(student);
        return ResponseEntity.status(HttpStatus.OK).body(savedStudent);
    }

    @GetMapping("/")
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
