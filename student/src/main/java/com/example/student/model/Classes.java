package com.example.student.model;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NonNull
    private String name;

    @NonNull
    private Integer numberS;
    private double averageC;
    @OneToMany(mappedBy = "classes")
    @Nullable
    private List<Student> students;
}
