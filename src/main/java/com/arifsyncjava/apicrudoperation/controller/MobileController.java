package com.arifsyncjava.apicrudoperation.controller;

import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.dto.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping (value = "/mobiles")
public class MobileController {

    private final MobileService mobileService;

    @PostMapping
    public ResponseEntity<HttpResponse> createDevice (
            @RequestBody MobileDeviceDTO mobileDeviceDTO ) {
        mobileService.create(mobileDeviceDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED)
                        .message("Resource created Successfully")
                        //.data(Map.of("mobile", savedDevice))
                        .build());
    }

    @GetMapping (path = "/{imei}")
    public ResponseEntity<HttpResponse> getMobileByImei (@PathVariable Long imei) {
        MobileDeviceDTO savedDevice = mobileService.readById(imei);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED)
                        .message("Resource created Successfully")
                        .data(Map.of("mobile", savedDevice))
                        .build());
    }


















}
