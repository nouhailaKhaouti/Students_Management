package com.example.student.Dto.Notes;

import com.example.student.Dto.Matiere.MatiereDto;
import lombok.Data;

@Data
public class NotesGetWithMatiereOnlyDto {
    private Double note;
    private MatiereDto matiereDto;
}
