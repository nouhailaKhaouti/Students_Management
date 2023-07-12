package com.example.student.Controller.Exception.Notes;

public class NotesExistException extends Exception {
    String id;
    public NotesExistException(String id){

        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
    }
}
