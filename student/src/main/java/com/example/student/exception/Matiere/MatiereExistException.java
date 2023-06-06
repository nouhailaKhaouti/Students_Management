package com.example.student.exception.Matiere;

public class MatiereExistException extends Exception {
    String name;
    public MatiereExistException(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }
}
