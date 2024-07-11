package com.arifsyncjava.apicrudoperation.exceptions;

import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler extends
        ResponseEntityExceptionHandler implements ErrorController  {


    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<HttpResponse> resourceNotFoundException (
            ResourceNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.NOT_FOUND.value())
                        .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .message(exception.getMessage())
                        .build());
    }

    @ExceptionHandler (InvalidException.class)
    public ResponseEntity<HttpResponse> InvalidExceptionHandler (InvalidException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.BAD_REQUEST.value())
                        .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                        .message(exception.getMessage())
                        .build());
    }









}
