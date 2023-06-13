package com.example.student.Service.Impl;

import com.example.student.Controller.exception.Classes.ClassesNameNotFoundException;
import com.example.student.Repository.ClassesRepository;
import com.example.student.Service.facade.ClassesService;
import com.example.student.Controller.exception.Classes.ClassesExistException;
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
    public Classes create(Classes classes) throws Exception{
        Classes classesComingFromDB = classesRepository.findByName(classes.getName());
        if(classesComingFromDB != null){
            throw new ClassesExistException(classes.getName());
        }
        classes.setId(UUID.randomUUID().toString());
        return classesRepository.save(classes);
    }

    @Override
    public Classes update(Classes classes) throws Exception {
        // check if Classes exists
        Optional<Classes> classesFromDB = classesRepository.findById(classes.getId());
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
    public Optional<Classes> findById(String id) throws Exception {
        Optional<Classes> classes = classesRepository.findById(id);
        if (classes == null) {
            throw new ClassesNameNotFoundException(id);
        }
        return classes;
    }

    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

}
