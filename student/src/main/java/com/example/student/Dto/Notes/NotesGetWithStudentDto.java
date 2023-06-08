package com.example.student.Dto.Notes;


import com.example.student.Dto.Matiere.MatiereDto;
import com.example.student.Dto.Student.StudentDto;
import lombok.Data;

@Data
public class NotesGetWithStudentDto {
    private Double note;
    private MatiereDto matiereDto;
    private StudentDto studentDto;
}
