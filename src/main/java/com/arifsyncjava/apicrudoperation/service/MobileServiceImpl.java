package com.arifsyncjava.apicrudoperation.service;

import com.arifsyncjava.apicrudoperation.dto.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MobileServiceImpl implements MobileService{

    private final MobileRepository mobileRepository;


    @Override
    public MobileDeviceDTO create(MobileDeviceDTO mobileDeviceDTO) {
        return null;
    }

    @Override
    public Optional<MobileDeviceDTO> readById(Long imei) {
        return Optional.empty();
    }

    @Override
    public MobileDeviceDTO update(MobileDeviceDTO mobileDeviceDTO) {
        return null;
    }

    @Override
    public Boolean delete(Long imei) {
        return null;
    }
}
