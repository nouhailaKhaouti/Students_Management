package com.example.student.model;


import com.fasterxml.jackson.annotation.*;
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
    private Classes classes;
    @OneToMany(mappedBy = "student")
    private List<Notes> notes;
}
