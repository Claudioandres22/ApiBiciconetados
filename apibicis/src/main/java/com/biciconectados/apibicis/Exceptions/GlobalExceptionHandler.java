package com.biciconectados.apibicis.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<?> handleDuplicateEntryException(DuplicateEntryException ex, WebRequest request) {
        String mensaje = ex.getMessage();
        return new ResponseEntity<>(mensaje, HttpStatus.CONFLICT);
    }


}