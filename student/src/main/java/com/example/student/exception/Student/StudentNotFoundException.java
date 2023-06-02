package com.example.student.exception.Student;

public class StudentNotFoundException extends Exception{

    private String CodeM;

    public StudentNotFoundException(String CodeM) {
        this.CodeM = CodeM;
    }

    public String getCodeM() {
        return CodeM;
    }

    public void setCodeM(String CodeM) {
        this.CodeM = CodeM;
    }
}
