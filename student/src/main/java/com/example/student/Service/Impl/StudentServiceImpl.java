package com.example.student.Service.Impl;
import com.example.student.Repository.StudentRepository;
import com.example.student.Service.facade.ClassesService;
import com.example.student.Service.facade.StudentService;
import com.example.student.exception.Student.StudentExistException;
import com.example.student.exception.Student.StudentNotFoundException;
import com.example.student.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentRepository studentRepository;
    @Autowired
    private ClassesService classesService;

    @Override
    public Student create(Student student) throws Exception{
        Student studentComingFromDB = studentRepository.findByCodeM(student.getCodeM());
        if(studentComingFromDB != null){
            throw new StudentExistException(student.getCodeM());
        }
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) throws Exception {
        // check if Student exists
        Student studentFromDB = studentRepository.findByCodeM(student.getCodeM());
        if (studentFromDB == null) {
            throw new StudentExistException(student.getCodeM());
        }
        // set and save employee if not
        return studentRepository.save(student);// return saved employee
    }

    @Override
    public Student findByCodeM(String CodeM) throws Exception{
        // check if employee exists
        Student studentFromDB = studentRepository.findByCodeM(CodeM);
        if(studentFromDB == null){
            throw new StudentNotFoundException(CodeM);
        }
        return studentRepository.findByCodeM(CodeM);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByIdWithClasses(Long id) throws StudentNotFoundException {
        return studentRepository.findByIdWithClasses(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

}
