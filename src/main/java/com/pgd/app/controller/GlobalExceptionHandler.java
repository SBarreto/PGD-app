package com.pgd.app.controller;

import com.pgd.app.exception.*;
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

    @ExceptionHandler(UsuarioYaExisteException.class)
    public ResponseEntity<String> handleUsuarioYaExisteException(UsuarioYaExisteException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> handleUsuarioNoExisteException(UsuarioNoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    @ExceptionHandler(ContrasenaIncorrectaException.class)
    public ResponseEntity<String> handleContrasenaIncorrectaException(ContrasenaIncorrectaException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    @ExceptionHandler(PreguntaFURAGNotFoundException.class)
    public ResponseEntity<String> handlePreguntaFURAGNotFoundException(PreguntaFURAGNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(RespuestaGENotFoundException.class)
    public ResponseEntity<String> handleRespuestaGENotFoundException(RespuestaGENotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(FormularioSinRespuestasException.class)
    public ResponseEntity<String> handleFormularioSinRespuestasException(FormularioSinRespuestasException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PreguntaGENotFoundException.class)
    public ResponseEntity<String> handlePreguntaGENotFoundException(PreguntaGENotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
