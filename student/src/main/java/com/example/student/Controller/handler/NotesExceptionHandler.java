package com.example.student.Controller.handler;

import com.example.student.exception.Notes.NotesExistException;
import com.example.student.exception.Notes.NotesNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class NotesExceptionHandler {

    final Logger log = LoggerFactory.getLogger(NotesExceptionHandler.class);

    @ExceptionHandler(value = NotesNotFoundException.class)
    public ResponseEntity<?> handleNotesNotFoundException(NotesNotFoundException exception) {
        return ResponseEntity.status(NOT_FOUND).body("Notes with " + exception.getId() + " is nowhere to be found");
    }

    @ExceptionHandler(value = NotesExistException.class)
    public ResponseEntity<?> handleNotesExistsException(NotesExistException exception) {
        return ResponseEntity.status(400).body("Notes with Id: " + exception.getId() + " is already existing");
    }
}
