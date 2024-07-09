package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.commandhandler.CreateMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequiredArgsConstructor
@RequestMapping (path = "/mobiles")

public class MobileController {

    private final CreateMobileDeviceCommandHandler createMobileDeviceCommandHandler;

    @PostMapping
    public ResponseEntity<HttpResponse> createDevice (
            @RequestBody MobileDeviceCreateRequest request) {
        return createMobileDeviceCommandHandler.execute(request);
    }





















}
