package com.example.student.model;


import com.example.student.Dto.Classes.ClassesGetDto;
import com.example.student.Dto.Notes.NotesGetWithMatiereOnlyDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String codeM;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "classes_id")
    @JsonBackReference
    private Classes classes;
    @OneToMany
    @JsonManagedReference
    private List<Notes> notes;
}
