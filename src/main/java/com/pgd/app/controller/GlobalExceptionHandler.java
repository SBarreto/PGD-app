package com.pgd.app.controller;

import com.pgd.app.Exception.EntidadNotFoundException;
import com.pgd.app.Exception.FormularioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntidadNotFoundException.class)
    public ResponseEntity<String> handleEntidadNotFoundException(EntidadNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(FormularioNotFoundException.class)
    public ResponseEntity<String> handleFormularioNotFoundException(FormularioNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
