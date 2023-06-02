package com.example.student.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String CodeM;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Classes classes;
    @OneToMany
    private Notes notes;
}
