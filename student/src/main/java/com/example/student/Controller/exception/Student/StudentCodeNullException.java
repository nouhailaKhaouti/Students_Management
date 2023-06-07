package com.example.student.Controller.exception.Student;

public class StudentCodeNullException extends  Exception{

    String CodeM;

    public StudentCodeNullException(String CodeM){
        this.CodeM=CodeM;
    }

    public String getCodeM() {
        return CodeM;
    }

    public void setCodeM(String CodeM) {
        this.CodeM = CodeM;
    }
}
