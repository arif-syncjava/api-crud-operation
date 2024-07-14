package com.arifsyncjava.apicrudoperation.device.commandhandler;

import com.arifsyncjava.apicrudoperation.Command;
import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import com.arifsyncjava.apicrudoperation.device.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceRequestValidator;
import com.arifsyncjava.apicrudoperation.device.MobileRepository;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceUpdateRequest;
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
public class UpdateMobileDeviceCommandHandler implements
        Command<MobileDeviceUpdateRequest, HttpResponse> {

    private final MobileRepository mobileRepository;
    private final MobileDeviceRequestValidator mobileDeviceRequestValidator;




    @Override
    public ResponseEntity<HttpResponse> execute(MobileDeviceUpdateRequest request) {
        Optional<MobileDevice> optionalMobileDevice = mobileRepository.findById(request.getImei());
        if (optionalMobileDevice.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        MobileDevice mobileDevice = mobileDeviceRequestValidator.validate(request.getRequest());
        MobileDevice savedDevice  = optionalMobileDevice.get();
        savedDevice.setImei(request.getImei());
        savedDevice.setBrandName(mobileDevice.getBrandName());
        savedDevice.setModelName(mobileDevice.getModelName());
        MobileDevice updatedDevice = mobileRepository.save(savedDevice);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.OK,
                        "Resource updated",
                        Map.of("mobile device", new MobileDeviceDTO(updatedDevice))
                ));
    }

}
