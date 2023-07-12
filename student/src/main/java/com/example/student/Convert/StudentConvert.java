package com.example.student.Convert;

import com.example.student.Dto.Student.StudentDto;
import com.example.student.Model.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class StudentConvert extends AbstractConverter<Student, StudentDto> {
    private final ModelMapper mapper;

    public StudentConvert(ModelMapper mapper) {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.mapper = mapper;
    }

    @Override
    public Student convertDtoToEntity(StudentDto studentDto) {
        return mapper.map(studentDto, Student.class);
    }

    @Override
    public StudentDto convertEntityToDto(Student student) {
        return mapper.map(student, StudentDto.class);
    }
}