package com.avance.cursoBasico.manejoExepciones.ExepcionesEnControladores;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

// Maneja errores globalmente en la API
@RestControllerAdvice
public class ErrorHandleController {

    // Captura cualquier error inesperado y retorna un 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ErrorResponse("Error interno del servidor: ")
        );
    }

    // Manejo específico: División por cero
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorResponse> handleDivisionByZero(ArithmeticException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponse("Operación matemática inválida: ")
        );
    }

    // Manejo de rutas no encontradas (Error 404)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(new ErrorResponse(ex.getStatusCode().toString()));
    }

    @Data
    @AllArgsConstructor
    static class ErrorResponse {
        private String message;
    }
}
