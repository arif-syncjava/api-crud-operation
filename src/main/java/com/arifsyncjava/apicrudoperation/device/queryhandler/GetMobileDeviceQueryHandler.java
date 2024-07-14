package com.arifsyncjava.apicrudoperation.device.queryhandler;

import com.arifsyncjava.apicrudoperation.Query;
import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import com.arifsyncjava.apicrudoperation.device.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.device.MobileRepository;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetMobileDeviceQueryHandler implements Query<String, HttpResponse> {

    private final MobileRepository mobileRepository;


    @Override
    public ResponseEntity<HttpResponse> execute(String imei) {
        Optional<MobileDevice> optionalMobileDevice =
                mobileRepository.findById(imei);
        if (optionalMobileDevice.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        MobileDevice mobileDevice = optionalMobileDevice.get();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.OK,
                        null,
                        Map.of("mobile device", new MobileDeviceDTO(mobileDevice))));
    }
}
