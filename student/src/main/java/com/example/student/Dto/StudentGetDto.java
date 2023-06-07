package com.example.student.Dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class StudentGetDto {
    @NotNull
    private String CodeM;

    private String firstName;

    private String lastName;
}
