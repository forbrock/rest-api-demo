package com.example.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgNotValid(MethodArgumentNotValidException exception,
                                                                HttpServletRequest request) {
        var shortMessage = "Validation failed for arguments";
        var bindingResult = exception.getBindingResult();
        var validationErrors = bindingResult.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField,
                        fieldError -> fieldError.getDefaultMessage()));
        var errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, LocalDateTime.now(),
                shortMessage, validationErrors, request.getServletPath());
        errorMessage.setValidationErrors(validationErrors);

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
