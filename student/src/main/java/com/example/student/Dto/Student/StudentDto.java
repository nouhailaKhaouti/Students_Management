package com.example.student.Dto.Student;

import com.example.student.Dto.Classes.ClassesDto;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class StudentDto {
    private UUID id;
    @NotNull
    private String codeM;

   @NotBlank(message = "First name must be filled")
    private String firstName;

    private String lastName;

    private ClassesDto classes;

}

