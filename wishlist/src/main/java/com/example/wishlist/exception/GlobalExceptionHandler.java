package com.example.wishlist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import lombok.Getter;

@Getter
@ControllerAdvice
public class GlobalExceptionHandler {

    private WebRequest webRequest;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        this.webRequest = request;
        String requestDescription = request.getDescription(false); // Get request description // Получение описания запроса
        String errorMessage = String.format("Resource not found: %s. Request: %s", ex.getMessage(), requestDescription);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalExceptionHandler(Exception ex, WebRequest request) {
        this.webRequest = request;
        String requestDescription = request.getDescription(false); // Get request description // Получение описания запроса
        String errorMessage = String.format("Internal server error: %s. Request: %s", ex.getMessage(), requestDescription);
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
