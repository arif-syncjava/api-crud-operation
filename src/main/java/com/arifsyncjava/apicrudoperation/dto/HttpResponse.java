package com.arifsyncjava.apicrudoperation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Getter @Setter
@JsonInclude (JsonInclude.Include.NON_DEFAULT)
public class HttpResponse<T> {

    @JsonFormat (pattern = "dd MMM-yyyy HH:mm:ss")
    private String timeStamp;
    private int httpCode;
    private HttpStatus status;
    private String message;
    private Map<String,T> data;

    public HttpResponse(HttpStatus httpStatus, String message,
                        Map<String, T> data) {
        this.timeStamp = LocalDateTime.now().toString();
        this.httpCode =httpStatus.value() ;
        this.status = httpStatus;
        this.message = message;
        this.data = data;
    }


}
