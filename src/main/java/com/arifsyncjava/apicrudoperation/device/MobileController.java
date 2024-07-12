package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.commandhandler.CreateMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.device.commandhandler.DeleteMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.device.commandhandler.UpdateMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.device.queryhandler.GetMobileDeviceQueryHandler;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceUpdateRequest;
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
    private final GetMobileDeviceQueryHandler getMobileDeviceQueryHandler;
    private final UpdateMobileDeviceCommandHandler
            updateMobileDeviceCommandHandler;
    private final UpdateMobileDeviceCommandHandlerV2 updateMobileDeviceCommandHandlerV2;

    @PostMapping
    public ResponseEntity<HttpResponse> createDevice (
            @RequestBody MobileDeviceCreateRequest request) {
        return createMobileDeviceCommandHandler.execute(request);
    }

    @GetMapping (path = "/{imei}")
    public ResponseEntity<HttpResponse> getDeviceByImei (
            @PathVariable("imei") String imei) {

        return getMobileDeviceQueryHandler.execute(imei);

    }


    @PutMapping (path = "/{imei}")
    public ResponseEntity<HttpResponse> updateDevice (
            @PathVariable String imei,
            @RequestBody MobileDeviceCreateRequest request) {
        return updateMobileDeviceCommandHandler
                .execute(new MobileDeviceUpdateRequest(imei,request));
    }



    @DeleteMapping(path = "/{imei}")
    public ResponseEntity<HttpResponse> deleteProductById (
            @PathVariable ("imei") String imei) {
        return deleteMobileDeviceCommandHandler.execute(imei);

    }





















}
