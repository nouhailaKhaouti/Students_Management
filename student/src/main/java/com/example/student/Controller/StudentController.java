package com.example.student.Controller;

import com.example.student.Dto.Notes.NotesGetWithMatiereOnlyDto;
import com.example.student.Dto.Student.StudentDto;
import com.example.student.Dto.Student.StudentGetDto;
import com.example.student.Service.Facade.StudentService;
import com.example.student.Model.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Slf4j
public class StudentController {
    final StudentService studentService;
    final ModelMapper modelMapper;

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
    public StudentGetDto findByCodeM(@PathVariable String CodeM) throws Exception{
        Student student =studentService.findByCodeM(CodeM);
        StudentGetDto studentDto=modelMapper.map(student,StudentGetDto.class);
        List<NotesGetWithMatiereOnlyDto> notesDtos = student.getNotes().stream()
                .map(notes -> {
                    NotesGetWithMatiereOnlyDto notesDto = modelMapper.map(notes, NotesGetWithMatiereOnlyDto.class);
                    return notesDto;
                })
                .collect(Collectors.toList());
        studentDto.setNotes(notesDtos);
        return studentDto;
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
    public ResponseEntity<?> getStudentWithNotes(@PathVariable String id) throws Exception {
        Optional<Student> studentOptional = studentService.findStudentByIdWithNotes(id);
        Student student = studentOptional.orElse(null); // Extract the Student from Optional

        if (student != null) {
            StudentGetDto studentDto = modelMapper.map(student, StudentGetDto.class);
            List<NotesGetWithMatiereOnlyDto> NotesDtos = student.getNotes().stream()
                    .map(notes -> modelMapper.map(notes, NotesGetWithMatiereOnlyDto.class))
                    .collect(Collectors.toList());
            studentDto.setNotes(NotesDtos);
            return ResponseEntity.ok(studentDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public List<StudentGetDto> findAll() {
        List<Student> studentList = studentService.findAll();
        Type listType = new TypeToken<List<StudentGetDto>>() {}.getType();
        List<StudentGetDto> studentDtoList = modelMapper.map(studentList, listType);
        for (StudentGetDto studentDto : studentDtoList) {
            List<NotesGetWithMatiereOnlyDto> notesDtos = studentDto.getNotes().stream()
                    .map(notes -> {
                        NotesGetWithMatiereOnlyDto notesDto = modelMapper.map(notes, NotesGetWithMatiereOnlyDto.class);
                        return notesDto;
                    })
                    .collect(Collectors.toList());
            studentDto.setNotes(notesDtos);
        }
        return studentDtoList;
    }

    @GetMapping("/Name/{Name}")
    public List<Student> findByClassesName(@PathVariable String Name) throws Exception {
        return studentService.findByClassesName(Name);
    }

    @DeleteMapping(value = "/{id}")
    public String DeleteS(@PathVariable String id) throws Exception {
        if(studentService.DeleteStudent(id)){
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }
}
