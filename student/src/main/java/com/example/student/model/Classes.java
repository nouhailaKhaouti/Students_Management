package com.example.student.model;

import jakarta.annotation.Nullable;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NonNull
    private String name;

    public Classes(long id, @NonNull String name, @NonNull Integer numberS, double averageC) {
        this.id = id;
        this.name = name;
        this.numberS = numberS;
        this.averageC = averageC;
    }

    @NonNull
    private Integer numberS;
    private double averageC;
    @OneToMany(mappedBy = "classes")
    @Nullable
    private List<Student> students;
}
