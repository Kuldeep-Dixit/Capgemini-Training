package com.cg.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ProductNotFoundException ex) {

        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), null),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));

        return new ResponseEntity<>(
                new ErrorResponse("Validation Failed", errors),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ProductValidException.class)
    public ResponseEntity<ErrorResponse> handleCustomValidation(ProductValidException ex) {

        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(), null),
                HttpStatus.BAD_REQUEST
        );
    }
}