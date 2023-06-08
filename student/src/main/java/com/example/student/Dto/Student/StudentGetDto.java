package com.example.student.Dto.Student;

import com.example.student.Dto.Classes.ClassesGetDto;
import com.example.student.Dto.Notes.NotesGetWithMatiereOnlyDto;
import com.example.student.Dto.Notes.NotesGetWithStudentDto;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
public class StudentGetDto {
    @NotNull
    private String codeM;
    private String firstName;
    private String lastName;
    private ClassesGetDto classes;
    private List<NotesGetWithMatiereOnlyDto> notes;
}
