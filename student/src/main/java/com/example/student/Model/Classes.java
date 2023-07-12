package com.example.student.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NonNull
    @NotBlank(message = "First name must be filled")
    @Pattern(regexp = "^(?!\\s*$).+", message = "First name must not be blank or contain only spaces")
    private String name;
    @NonNull
    private Integer numberS;
    private double averageC=0.0;
    @OneToMany(mappedBy = "classes")
    @JsonManagedReference
    private List<Student> student;
}

