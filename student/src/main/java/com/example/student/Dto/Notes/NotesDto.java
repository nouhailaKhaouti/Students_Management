package com.example.student.Dto.Notes;

import com.example.student.Dto.Classes.ClassesDto;
import com.example.student.Dto.Matiere.MatiereDto;
import com.example.student.Dto.Student.StudentDto;
import lombok.Data;

@Data
public class NotesDto {
    private  Long id;
    private Double note;
    private MatiereDto matiere;
    private StudentDto student;
}
