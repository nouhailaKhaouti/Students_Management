package com.example.student.model;

import com.example.student.Dto.Notes.NotesGetWithStudentDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String label;
    @OneToMany
    @JsonManagedReference
    private List<Notes> notes;
}
