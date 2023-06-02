package com.example.student.exception.Student;

public class StudentExistException extends Exception{

    String CodeM;

    public StudentExistException(String CodeM) {
        this.CodeM = CodeM;
    }

    public String getCodeM() {
        return CodeM;
    }

    public void setCodeM(String CodeM) {
        this.CodeM = CodeM;
    }

}
