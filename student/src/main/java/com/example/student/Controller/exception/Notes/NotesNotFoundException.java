package com.example.student.Controller.exception.Notes;

import java.util.UUID;

public class NotesNotFoundException extends Exception{

    String id;
    public NotesNotFoundException(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
    }
}
