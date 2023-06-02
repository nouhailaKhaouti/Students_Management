package com.example.student.model;

import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private Integer numberS;
    private double averageC;
    @OneToMany(mappedBy = "classes")
    private List<Student> students;
}
