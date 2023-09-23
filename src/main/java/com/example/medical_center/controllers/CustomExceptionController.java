package com.example.medical_center.controllers;

import com.example.medical_center.exceptions.GenericExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class CustomExceptionController {
//    @ExceptionHandler(GenericExceptions.class)
//    public ResponseEntity<String> customException(GenericExceptions exceptions){
//        return new ResponseEntity<>(exceptions.getMessage(), HttpStatus.valueOf(exceptions.getStatus()));
//    }
    @ExceptionHandler(GenericExceptions.class)
    public String customError(Model model, GenericExceptions exceptions){
        model.addAttribute("errorDescription", exceptions.getMessage());
        return "/error/error";
    }
}
