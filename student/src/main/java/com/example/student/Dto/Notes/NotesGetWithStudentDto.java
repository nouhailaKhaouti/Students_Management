package com.example.student.Dto.Notes;


import com.example.student.Dto.Matiere.MatiereDto;
import com.example.student.Dto.Matiere.MatiereGetDto;
import com.example.student.Dto.Student.StudentDto;
import com.example.student.Dto.Student.StudentGetDto;
import com.example.student.Dto.Student.StudentWithOutClassesDto;
import lombok.Data;

@Data
public class NotesGetWithStudentDto {
    private Double note;
    private MatiereGetDto matiere;
    private StudentWithOutClassesDto student;
}
