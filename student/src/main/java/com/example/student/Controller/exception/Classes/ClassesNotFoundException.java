package com.example.student.Controller.exception.Classes;

public class ClassesNotFoundException extends Exception{
    String name;

    public ClassesNotFoundException(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }
}
