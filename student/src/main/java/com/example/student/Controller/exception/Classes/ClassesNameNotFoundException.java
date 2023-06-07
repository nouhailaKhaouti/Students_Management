package com.example.student.Controller.exception.Classes;

public class ClassesNameNotFoundException extends  Exception{

    String name;

    public ClassesNameNotFoundException(String name){
        this.name=name;
    }

    public String getClasses_id() {
        return name;
    }

    public void setClasses_id(String name) {
        this.name= name;
    }
}
