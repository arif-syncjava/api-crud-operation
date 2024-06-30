package com.arifsyncjava.apicrudoperation.controller;

import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.model.SimCard;
import com.arifsyncjava.apicrudoperation.service.SimCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequiredArgsConstructor
@RestController (value = "/simCards")
public class SimCardController {
    private final SimCardService simCardService;

    @PostMapping (path = "/{imei}")
    public ResponseEntity<HttpResponse> create (
            @PathVariable("imei") Long imei,
            @RequestBody SimCard simCard
            ) {
        SimCard savedSimCard  = simCardService.create(imei, simCard);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED.getReasonPhrase())
                        .message(" New Resource Created Successfully")
                        .data(Map.of("simCard",savedSimCard))
                        .build());

    }

    @GetMapping ("/{number}")
    public ResponseEntity<HttpResponse> getSimCardByNumber (
            @PathVariable Integer number) {
        SimCard simCard = simCardService.getSimCardByNumber(number);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.OK,
                        null,
                        Map.of("simCard",simCard)
                ));
    }

    @PutMapping (value = "/{number}")
    public ResponseEntity<HttpResponse> update (
            @PathVariable Integer number, @RequestBody SimCard simCard) {
        simCardService.update(number, simCard);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.OK,
                        "Updated Successfully",
                        null
                ));
    }

    @DeleteMapping ("/{number}")
    public ResponseEntity<HttpResponse> delete (Integer number) {
        simCardService.delete(number);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.OK,
                        "Resource Deleted Successfully",
                        null
                ));
    }











}
