package com.example.student.Service.Impl;
import com.example.student.Repository.StudentRepository;
import com.example.student.Service.facade.ClassesService;
import com.example.student.Service.facade.StudentService;
import com.example.student.Controller.exception.Student.StudentExistException;
import com.example.student.Controller.exception.Student.StudentNotFoundException;
import com.example.student.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentRepository studentRepository;
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
        studentFromDB.setFirstName(student.getFirstName());
        studentFromDB.setLastName(student.getLastName());
        // Save the updated student object
        return studentRepository.save(studentFromDB);
    }
    @Override
    public Student findByCodeM(String CodeM) throws Exception{
        // check if student exists
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
    public List<Student> findByClassesName(String Name) {

        return studentRepository.findByClassesName(Name);
    }

    @Override
    public Optional<Student> findStudentByIdWithNotes(String id) {
        Optional<Student> student=studentRepository.findStudentByIdWithNotes(id);
        return student;
    }

    @Override
    public Boolean DeleteStudent(String id){
        Optional<Student> studentO = studentRepository.findById(id);

        if (studentO.isPresent()) {
            Student student = studentO.get();
            studentRepository.delete(student);
            return true;
        } else {
            System.out.println("Student Not Found");
            return false;
        }

    }
}
