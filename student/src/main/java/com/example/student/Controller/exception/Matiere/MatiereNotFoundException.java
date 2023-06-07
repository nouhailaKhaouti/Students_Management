package com.example.student.Controller.exception.Matiere;

public class MatiereNotFoundException extends Throwable {
    String name;
    public MatiereNotFoundException(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }
}
