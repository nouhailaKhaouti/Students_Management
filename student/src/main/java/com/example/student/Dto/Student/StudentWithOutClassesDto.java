package com.example.student.Dto.Student;

import com.example.student.Dto.Classes.ClassesGetDto;
import com.example.student.Dto.Notes.NotesGetWithMatiereOnlyDto;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
@Data
public class StudentWithOutClassesDto {
    @NotNull
    private String codeM;
    private String firstName;
    private String lastName;
}
