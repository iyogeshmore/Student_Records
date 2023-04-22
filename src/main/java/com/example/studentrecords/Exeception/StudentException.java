package com.example.studentrecords.Exeception;

public class StudentException extends RuntimeException {
    String message;

    public StudentException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
