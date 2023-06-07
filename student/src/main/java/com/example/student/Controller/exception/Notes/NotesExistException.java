package com.example.student.Controller.exception.Notes;

public class NotesExistException extends Exception {
    Long id;
    public NotesExistException(Long id){
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }
}
