package com.example.student.Controller.handler;

import com.example.student.Controller.exception.Classes.ClassesNameNotFoundException;
import com.example.student.Controller.exception.Classes.ClassesExistException;
import com.example.student.Controller.exception.Classes.ClassesNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;
@ControllerAdvice
public class ClassesExceptionHandler {
    final Logger log = LoggerFactory.getLogger(ClassesExceptionHandler.class);

    @ExceptionHandler(value = ClassesNotFoundException.class)
    public ResponseEntity<?> handleClassesNotFoundException(ClassesNotFoundException exception) {
        return ResponseEntity.status(NOT_FOUND).body("Classes with " + exception.getClasses_id() + " is nowhere to be found");
    }

    @ExceptionHandler(value = ClassesExistException.class)
    public ResponseEntity<?> handleClassesExistsException(ClassesExistException exception) {
        return ResponseEntity.status(400).body("Classes with Name Massar: " + exception.getClasses_id() + " is already existing");
    }

    @ExceptionHandler(value = ClassesNameNotFoundException.class)
    public ResponseEntity<?> handleClassesNameNotFoundException(ClassesNameNotFoundException exception) {
        return ResponseEntity.status(400).body("Classes NameM is null");
    }
}
