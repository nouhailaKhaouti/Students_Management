package com.example.student.Controller.Exception.Classes;

public class ClassesExistException extends Exception{

    String classes_id;

    public ClassesExistException(String classes_id){
        this.classes_id=classes_id;
    }

    public String getClasses_id() {
        return classes_id;
    }

    public void setClasses_id(String classes_id) {
        this.classes_id= classes_id;
    }
}
