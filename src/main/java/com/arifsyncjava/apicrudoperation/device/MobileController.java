package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequiredArgsConstructor
@RequestMapping (path = "/mobiles")

public class MobileController {

    public ResponseEntity<MobileDeviceDTO> createDevice (
            DeviceCreateRequest request) {

    }










    private final MobileService mobileService;


    @RequestMapping (path = "/error")
    public ResponseEntity<HttpResponse> NoHandlerFoundException() {
        return ResponseEntity.badRequest()
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(BAD_REQUEST.value())
                        .status(BAD_REQUEST.getReasonPhrase())
                        .message("There is no mapping  for this path on the server")
                        .build());
    }

    @PostMapping
    public ResponseEntity<HttpResponse> createDevice (
            @RequestBody MobileDeviceDTO mobileDeviceDTO ) {
        mobileService.create(mobileDeviceDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.CREATED.value())
                        .status(HttpStatus.CREATED.getReasonPhrase())
                        .message("Resource created Successfully")
                        //.data(Map.of("mobile", savedDevice))
                        .build());
    }

    @GetMapping (path = "/{imei}")
    public ResponseEntity<HttpResponse> getMobileByImei (@PathVariable Long imei) {
        MobileDeviceDTO savedDevice = mobileService.findById(imei);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.getReasonPhrase())
                        .message("Resource created Successfully")
                        .data(Map.of("mobile", savedDevice))
                        .build());
    }

    @PutMapping (path = "/{imei}")
    public ResponseEntity<HttpResponse> updateDeviceInfo (
                                                           @PathVariable ("imei")  Long imei,
                                                          @RequestBody MobileDeviceDTO mobileDeviceDTO) {
        mobileService.update(imei,mobileDeviceDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.getReasonPhrase())
                        .message("Resource updated Successfully")
                        .build());
    }

    @DeleteMapping (path = "/{id}")
    public void deleteById (@PathVariable Long id) {
        mobileService.deleteById(id);
    }



    @DeleteMapping (path = "/abc/{id}")
    public ResponseEntity<HttpResponse> delete (@PathVariable(name = "id") Long imei) {
       mobileService.deleteById(imei);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(HttpResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .httpCode(HttpStatus.NO_CONTENT.value())
                        .status(HttpStatus.NO_CONTENT.getReasonPhrase())
                        .message("Resource deleted Successfully")
                        .build());
    }
























}
