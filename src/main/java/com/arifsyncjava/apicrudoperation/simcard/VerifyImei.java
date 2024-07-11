package com.arifsyncjava.apicrudoperation.simcard;

import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import com.arifsyncjava.apicrudoperation.device.MobileRepository;
import com.arifsyncjava.apicrudoperation.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class VerifyImei {

    private MobileRepository mobileRepository;

    public void verify (String imei) {
       Optional<MobileDevice> optionalMobileDevice =  mobileRepository.findById(imei);
        if (optionalMobileDevice.isEmpty()) {
            throw new ResourceNotFoundException();
        }



    }


}
