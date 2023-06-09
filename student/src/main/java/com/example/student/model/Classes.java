package com.example.student.model;

import com.example.student.Dto.Student.StudentGetDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Classes{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", numberS=").append(numberS);
        sb.append(", averageC=").append(averageC);

        if (student != null && !student.isEmpty()) {
            sb.append(", students=[");
            for (int i = 0; i < student.size(); i++) {
                sb.append(student.get(i).getFirstName()).append(" ").append(student.get(i).getLastName());
                if (i < student.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        } else {
            sb.append(", students=[]");
        }

        sb.append("}");
        return sb.toString();
    }
}

