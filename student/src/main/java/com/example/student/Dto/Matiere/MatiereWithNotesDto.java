package com.example.student.Dto.Matiere;

import com.example.student.Dto.Notes.NotesGetWithStudentDto;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class MatiereWithNotesDto {
    @NotNull
    @NotBlank(message = "First name must be filled")
    @Pattern(regexp = "^(?!\\s*$).+", message = "First name must not be blank or contain only spaces")
    private String label;
    private List<NotesGetWithStudentDto> Notes;
}
