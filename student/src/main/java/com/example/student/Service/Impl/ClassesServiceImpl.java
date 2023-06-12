package com.example.student.Service.Impl;

import com.example.student.Controller.exception.Classes.ClassesNameNotFoundException;
import com.example.student.Repository.ClassesRepository;
import com.example.student.Service.facade.ClassesService;
import com.example.student.Controller.exception.Classes.ClassesExistException;
import com.example.student.Controller.exception.Classes.ClassesNotFoundException;
import com.example.student.model.Classes;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ClassesServiceImpl implements ClassesService {

    final ClassesRepository classesRepository;
    @Override
    public Classes create(Classes student) throws Exception{
        Classes studentComingFromDB = classesRepository.findByName(student.getName());
        if(studentComingFromDB != null){
            throw new ClassesExistException(student.getName());
        }
        return classesRepository.save(student);
    }

    @Override
    public Classes update(Classes classes) throws Exception {
        // check if Classes exists
        Classes classesFromDB = classesRepository.findByName(classes.getName());
        if (classesFromDB == null) {
            throw new ClassesNameNotFoundException(classes.getName());
        }
        return classesRepository.save(classes);
    }

    @Override
    public Classes findByName(String Name) throws Exception {
        Classes classes = classesRepository.findByName(Name);
        if (classes == null) {
            throw new ClassesNameNotFoundException(Name);
        }
        return classes;
    }

    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Optional<Classes> classesbyId(UUID id){
        return classesRepository.findById(id);
    }
}
