package com.example.student.Convert;

import com.example.student.Dto.StudentDto;
import com.example.student.model.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

public class StudentConvert extends AbstractConverter<Student, StudentDto>{
    final ModelMapper mapper;

    public StudentConverter(ModelMapper mapper) {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.mapper = mapper;
    }

    public StudentConvert(ModelMapper mapper) {
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
