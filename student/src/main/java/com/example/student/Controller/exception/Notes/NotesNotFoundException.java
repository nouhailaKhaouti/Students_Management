package com.example.student.Controller.exception.Notes;

public class NotesNotFoundException extends Exception{

    Long id;
    public NotesNotFoundException(Long id){
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }
}
