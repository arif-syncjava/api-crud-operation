package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.commandhandler.CreateMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.device.commandhandler.DeleteMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping (path = "/mobiles")

public class MobileController {


    private final CreateMobileDeviceCommandHandler createMobileDeviceCommandHandler;
    private final DeleteMobileDeviceCommandHandler deleteMobileDeviceCommandHandler;

    @PostMapping
    public ResponseEntity<HttpResponse> createDevice (
            @RequestBody MobileDeviceCreateRequest request) {
        return createMobileDeviceCommandHandler.execute(request);
    }

    @DeleteMapping(path = "/{imei}")
    public ResponseEntity<HttpResponse> deleteProductById (
            @PathVariable ("imei") String imei) {
        return deleteMobileDeviceCommandHandler.execute(imei);

    }





















}
