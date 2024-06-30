package com.arifsyncjava.apicrudoperation.exception;

import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestControllerAdvice
public class GlobalExceptionHandler implements ErrorController {

    @RequestMapping(path = "/error")
    public ResponseEntity<HttpResponse> handleError() {
        return ResponseEntity.badRequest()
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(BAD_REQUEST.value())
                        .status(BAD_REQUEST.getReasonPhrase())
                        .message("There is no mapping  for this path on the server")
                        .build());
    }

    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<HttpResponse> resourceNotFoundException (
            ResourceNotFoundException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.NOT_FOUND.value())
                        .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .message(exception.getMessage())
                        .build());
    }





}
