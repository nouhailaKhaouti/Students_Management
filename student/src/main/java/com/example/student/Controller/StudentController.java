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
    @PostMapping("/saveStudent")
    public ResponseEntity<?> create(@RequestBody Student student) throws Exception {
        if (student == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student data");
        }
        Student savedStudent = studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("/{CodeM}")
    public StudentDto findByCodeM(@PathVariable String CodeM) throws Exception{
        Student student =studentService.findByCodeM(CodeM);
        StudentDto studentS = studentConvert.convertEntityToDto(student);
        return studentS;
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

    @GetMapping("/Name")
    public List<Student> findByClassesName(@PathVariable String Name) throws Exception {
        return studentService.findByClassesName(Name);
    }

    @DeleteMapping(value = "/{id}")
    public String DeleteS(@PathVariable Long id) throws Exception {
        if(studentService.DeleteStudent(id)){
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }
}
