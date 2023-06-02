package com.example.student.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
public class Classes {
    @Id
    @SequenceGenerator(
            name = "student-sequence",
            sequenceName = "student-sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student-sequence"
    )
    private long id;
    private String name;
    private Integer numberS;
    private double averageC;
    @OneToMany(mappedBy = "classes")
    private List<Student> students;
}
