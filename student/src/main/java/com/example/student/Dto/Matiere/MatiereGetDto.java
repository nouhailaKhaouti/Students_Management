package com.example.student.Dto.Matiere;

import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MatiereGetDto {
    @NotNull
    @NotBlank(message = "First name must be filled")
    @Pattern(regexp = "^(?!\\s*$).+", message = "First name must not be blank or contain only spaces")
    private String label;
}
