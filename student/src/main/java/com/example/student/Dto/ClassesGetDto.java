package com.example.student.Dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class ClassesGetDto {
    private String name;
    private Integer numberS;
    private Double averageC;
    private List<StudentGetDto> students;
}
