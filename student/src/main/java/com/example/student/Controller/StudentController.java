package com.example.student.Controller;

import com.example.student.Convert.StudentConvert;
import com.example.student.Dto.Student.StudentDto;
import com.example.student.Dto.Student.StudentGetDto;
import com.example.student.Service.facade.ClassesService;
import com.example.student.Service.facade.StudentService;
import com.example.student.model.Matiere;
import com.example.student.model.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Slf4j
public class StudentController {
    @Autowired
    private ModelMapper modelMapper;
    final StudentService studentService;
    final ClassesService classesService;
    final StudentConvert studentConvert;
    // create new student
    @PostMapping("/saveStudent")
    public ResponseEntity<?> create(@RequestBody StudentDto studentDto) throws Exception {
        Student student = modelMapper.map(studentDto, Student.class);
        if (student == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student data");
        }
        Student savedStudent = studentService.create(student);
        StudentGetDto studentD = modelMapper.map(savedStudent, StudentGetDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentD);
    }

    @GetMapping("/{CodeM}")
    public Student findByCodeM(@PathVariable String CodeM) throws Exception{
        Student student =studentService.findByCodeM(CodeM);
        return student;
    }

    @PutMapping("/")
    public ResponseEntity<?> update( @RequestBody StudentDto studentDto) throws Exception{
        Student student = modelMapper.map(studentDto, Student.class);
        if (student == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student data");
        }
        Student savedStudent = studentService.update(student);
        StudentGetDto studentD = modelMapper.map(savedStudent, StudentGetDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentD);
    }

    @GetMapping("/All/{id}")
    public ResponseEntity<?> getStudentWithNotes(@PathVariable Long id) throws Exception {
        Optional<Student> studentOptional = studentService.findStudentByIdWithNotes(id);
        StudentGetDto student=modelMapper.map(studentOptional, StudentGetDto.class);
        if (student!= null) {
            StudentGetDto studentS = student;
            return ResponseEntity.ok(studentS);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/")
    public List<StudentGetDto> findAll() {
        List<Student> studentList = studentService.findAll();
        Type listType = new TypeToken<List<StudentGetDto>>() {}.getType();
        return modelMapper.map(studentList, listType);
    }

    @GetMapping("/Name/{Name}")
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
