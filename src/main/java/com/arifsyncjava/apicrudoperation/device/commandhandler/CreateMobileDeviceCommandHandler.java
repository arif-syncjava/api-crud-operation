package com.arifsyncjava.apicrudoperation.device.commandhandler;

import com.arifsyncjava.apicrudoperation.Command;
import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import com.arifsyncjava.apicrudoperation.device.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.device.MobileRepository;
import com.arifsyncjava.apicrudoperation.device.Validator;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service

public class CreateMobileDeviceCommandHandler
        implements Command<MobileDeviceCreateRequest, HttpResponse> {

    private final MobileRepository mobileRepository;



    @Override
    public ResponseEntity<HttpResponse> execute(MobileDeviceCreateRequest request) {
        MobileDevice mobileDevice = Validator.validate(request);
        MobileDevice savedMobileDevice= mobileRepository.save(mobileDevice);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new HttpResponse(
                        HttpStatus.CREATED,
                        "Resource created successfully",
                        Map.of("Mobile Device",new MobileDeviceDTO(savedMobileDevice))
                        )
                );
    }
}
