package com.example.student.Dto.Notes;

import com.example.student.Dto.Classes.ClassesDto;
import com.example.student.Dto.Matiere.MatiereDto;
import com.example.student.Dto.Student.StudentDto;
import lombok.Data;

import java.util.UUID;

@Data
public class NotesDto {
    private UUID id;
    private Double note;
    private MatiereDto matiere;
    private StudentDto student;
}
