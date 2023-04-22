package com.example.studentrecords.Exeception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(value = StudentException.class)
    public String userAlreadyExist(StudentException empException) {
        return empException.getMessage();
    }
}
