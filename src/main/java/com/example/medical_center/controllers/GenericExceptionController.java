package com.example.medical_center.controllers;

import com.example.medical_center.exceptions.GenericExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionController {
    @ExceptionHandler(GenericExceptions.class)
    public ResponseEntity<String> genericException(GenericExceptions genericExceptions){
        return ResponseEntity.status(genericExceptions.getStatus()).body(genericExceptions.getMessage());
    }
}
