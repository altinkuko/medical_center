package com.example.medical_center.controllers;

import com.example.medical_center.exceptions.GenericExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionController {
    @ExceptionHandler(GenericExceptions.class)
    public ResponseEntity<String> customException(GenericExceptions exceptions){
        return new ResponseEntity<>(exceptions.getMessage(), HttpStatus.valueOf(exceptions.getStatus()));
    }
}
