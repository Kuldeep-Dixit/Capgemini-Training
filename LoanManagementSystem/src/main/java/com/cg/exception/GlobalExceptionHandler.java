package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLoanAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidAmount(InvalidLoanAmountException ex) {
        return new ErrorResponse(ex.getMessage(), 400);
    }

    @ExceptionHandler(DuplicateLoanApplicationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleDuplicate(DuplicateLoanApplicationException ex) {
        return new ErrorResponse(ex.getMessage(), 409);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(LoanNotFoundException ex) {
        return new ErrorResponse(ex.getMessage(), 404);
    }
}