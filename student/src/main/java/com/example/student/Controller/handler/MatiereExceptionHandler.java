package com.example.student.Controller.handler;

import com.example.student.exception.Matiere.MatiereExistException;
import com.example.student.exception.Matiere.MatiereNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;
@ControllerAdvice
public class MatiereExceptionHandler {
    final Logger log = LoggerFactory.getLogger(MatiereExceptionHandler.class);

    @ExceptionHandler(value = MatiereNotFoundException.class)
    public ResponseEntity<?> handleMatiereNotFoundException(MatiereNotFoundException exception) {
        return ResponseEntity.status(NOT_FOUND).body("Matiere with " + exception.getName() + " is nowhere to be found");
    }

    @ExceptionHandler(value = MatiereExistException.class)
    public ResponseEntity<?> handleMatiereExistException(MatiereExistException exception) {
        return ResponseEntity.status(400).body("Matiere with Name: " + exception.getName() + " is already existing");
    }

}
