package com.example.student.Service.Impl;

import com.example.student.Repository.ClassesRepository;
import com.example.student.Service.facade.ClassesService;
import com.example.student.exception.Classes.ClassesExistException;
import com.example.student.exception.Classes.ClassesNotFoundException;
import com.example.student.model.Classes;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public Classes update(Classes student) throws Exception {
        // check if Classes exists
        Classes studentFromDB = classesService.findByName(student.getName());
        if (studentFromDB == null) {
            throw new ClassesExistException(student.getName());
        }
        // set and save employee if not
        return classesService.save(student);// return saved employee
    }

    @Override
    public Classes findByName(String Name) throws Exception{
        // check if employee exists
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
}
