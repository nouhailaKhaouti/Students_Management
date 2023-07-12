package com.example.student.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String codeM;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "classes_id")
    @JsonBackReference
    private Classes classes;
    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Notes> notes;
}
