package com.arifsyncjava.apicrudoperation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@SuperBuilder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@JsonInclude (JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {

    @JsonFormat (
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MMM-yyyy HH:mm:ss"
    )
    private LocalDateTime timeStamp;
    private int httpCode;
    private String status;
    private String message;
    private Map<?,?> data;

    public HttpResponse (HttpStatus httpStatus, String message, Map<?,?> data ) {
        this.timeStamp = LocalDateTime.now();
        this.httpCode = httpStatus.value();
        this.status = httpStatus.getReasonPhrase();
        this.message = message;
        this.data= data;
    }




}
