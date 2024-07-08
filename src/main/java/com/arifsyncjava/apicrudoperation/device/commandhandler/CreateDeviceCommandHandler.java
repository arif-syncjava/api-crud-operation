package com.arifsyncjava.apicrudoperation.device.commandhandler;

import com.arifsyncjava.apicrudoperation.Command;
import com.arifsyncjava.apicrudoperation.device.DeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.device.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.device.MobileDeviceDTOMapper;
import com.arifsyncjava.apicrudoperation.device.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class CreateDeviceCommandHandler
        implements Command<DeviceCreateRequest, MobileDeviceDTO> {

    private final MobileRepository mobileRepository;



    @Override
    public ResponseEntity<MobileDeviceDTO> execute(DeviceCreateRequest request) {
        MobileDeviceDTOMapper.convertToModel(request);

        return null;
    }
}
