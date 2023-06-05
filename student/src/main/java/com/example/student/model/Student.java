package com.example.student.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String codeM;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Classes classes;
}
