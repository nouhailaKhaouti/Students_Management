package com.example.student.Controller.exception.Notes;

import java.util.UUID;

public class NotesExistException extends Exception {
    UUID id;
    public NotesExistException(UUID id){

        this.id=id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id= id;
    }
}
