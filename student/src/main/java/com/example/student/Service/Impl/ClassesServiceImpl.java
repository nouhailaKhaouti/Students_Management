package com.example.student.Service.Impl;

import com.example.student.Repository.ClassesRepository;
import com.example.student.Service.facade.ClassesService;
import com.example.student.exception.Classes.ClassesExistException;
import com.example.student.exception.Classes.ClassesNotFoundException;
import com.example.student.model.Classes;
import com.example.student.model.Student;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ClassesServiceImpl implements ClassesService {

    final ClassesRepository classesService;
    @Override
    public Classes create(Classes student) throws Exception{
        Classes studentComingFromDB = classesService.findByName(student.getName());
        if(studentComingFromDB != null){
            throw new ClassesExistException(student.getName());
        }
        return classesService.save(student);
    }

    @Override
    public Classes update(Classes classes) throws Exception {
        // check if Classes exists
        Classes classesFromDB = classesService.findByName(classes.getName());
        if (classesFromDB == null) {
            throw new ClassesNotFoundException(classes.getName());
        }
        return classesService.save(classes);
    }

    @Override
    public Classes findByName(String Name) throws Exception{

        Classes studentFromDB = classesService.findByName(Name);
        if(studentFromDB == null){
            throw new ClassesNotFoundException(Name);
        }
        return classesService.findByName(Name);
    }

    @Override
    public List<Classes> findAll() {
        return classesService.findAll();
    }

    @Override
    public Optional<Classes> classesbyId(Long id){
        return classesService.findById(id);
    }
}
