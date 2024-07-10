package com.arifsyncjava.apicrudoperation.device.commandhandler;

import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import com.arifsyncjava.apicrudoperation.device.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.device.MobileRepository;
import com.arifsyncjava.apicrudoperation.device.Validator;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
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
public class UpdateMobileDeviceCommandHandlerV2 {

    private final MobileRepository mobileRepository;
    private final Validator validator;


    public ResponseEntity<HttpResponse> execute(
            String imei, MobileDeviceCreateRequest request) {
        Optional<MobileDevice> optionalMobileDevice =
                mobileRepository.findById(imei);

        if (optionalMobileDevice.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        MobileDevice mobileDevice = validator.validate(request);

        MobileDevice savedDevice  = optionalMobileDevice.get();
        savedDevice.setImei(imei);
        savedDevice.setBrandName(mobileDevice.getBrandName());
        savedDevice.setModelName(mobileDevice.getModelName());

        MobileDevice updatedDevice = mobileRepository.save(mobileDevice);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.OK,
                        "Resource Updated",
                        Map.of("mobile device", new MobileDeviceDTO(updatedDevice))
                ));
    }

}

