package com.example.student.Dto.Classes;

import com.example.student.Dto.Student.StudentGetDto;
import com.example.student.Dto.Student.StudentWithOutClassesDto;
import lombok.Data;

import java.util.List;

@Data
public class ClassesGetDto {
    private String name;
    private Integer numberS;
    private Double averageC;
    private List<StudentWithOutClassesDto> students;
}
