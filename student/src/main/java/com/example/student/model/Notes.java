package com.example.student.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    private Matiere matiere;
    private Double note;
    @ManyToOne
    private Student student;
}
