package com.example.student.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;
@Entity
@Data
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private Integer numberS;
    private double averageC;
}
