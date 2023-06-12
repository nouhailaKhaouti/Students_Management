package com.example.student.Controller.exception.Classes;

public class ClassesNameNotFoundException extends  Exception{

    String name;

    public ClassesNameNotFoundException(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }
}
