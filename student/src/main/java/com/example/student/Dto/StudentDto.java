package com.example.student.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Data
public class StudentDto {
    @NotNull
    private Long id;

    @NotNull
    private String CodeM;

   // @NotBlank(message = "First name must be filled")
    private String firstName;

    private String lastName;

    private ClassesDto classes;

}

