package com.arifsyncjava.apicrudoperation.device.commandhandler;

import com.arifsyncjava.apicrudoperation.Command;
import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import com.arifsyncjava.apicrudoperation.device.MobileRepository;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteMobileDeviceCommandHandler
        implements Command<String,HttpResponse> {

    private final MobileRepository mobileRepository;

    @Override
    public ResponseEntity<HttpResponse> execute(String imei) {
        Optional<MobileDevice> optionalMobileDevice =
                mobileRepository.findById(imei);

        if (optionalMobileDevice.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        mobileRepository.delete(optionalMobileDevice.get());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.NO_CONTENT,
                        "Resource deleted Successfully",
                        null
                ));

    }
}
