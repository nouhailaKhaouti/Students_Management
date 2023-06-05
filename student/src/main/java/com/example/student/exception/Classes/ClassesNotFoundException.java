package com.example.student.exception.Classes;

public class ClassesNotFoundException extends Exception{
    String name;

    public ClassesNotFoundException(String name){
        this.name=name;
    }

    public String getClasses_id() {
        return name;
    }

    public void setClasses_id(String name) {
        this.name= name;
    }
}
