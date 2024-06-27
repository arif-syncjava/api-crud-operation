package com.arifsyncjava.apicrudoperation.service;

import com.arifsyncjava.apicrudoperation.dto.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.model.MobileDevice;
import com.arifsyncjava.apicrudoperation.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.arifsyncjava.apicrudoperation.dtomapper.MobileDeviceDTOMapper.convertToDTO;
import static com.arifsyncjava.apicrudoperation.dtomapper.MobileDeviceDTOMapper.convertToModel;

@Service
@RequiredArgsConstructor
public class MobileServiceImpl implements MobileService{

    private final MobileRepository mobileRepository;


    @Override
    public MobileDeviceDTO create(MobileDeviceDTO mobileDeviceDTO) {
       MobileDevice mobileDevice = convertToModel(mobileDeviceDTO);
       MobileDevice savedDevice = mobileRepository.insert(mobileDevice);
        return convertToDTO(savedDevice);
    }

    @Override
    public MobileDeviceDTO readById(Long imei) {
        MobileDevice mobileDevice = mobileRepository
                .selectById(imei)
                .orElseThrow(() -> new RuntimeException(" Resource Not Found"));
        return convertToDTO(mobileDevice);
    }

    @Override
    public MobileDeviceDTO update(Long imei, MobileDeviceDTO mobileDeviceDTO) {
        mobileRepository
                .selectById(imei)
                .orElseThrow(() -> new RuntimeException(" Resource Not Found"));

        MobileDevice mobileDevice = convertToModel(mobileDeviceDTO);
        MobileDevice updatedDevice = mobileRepository.insert(mobileDevice);
        return convertToDTO(updatedDevice);

    }

    @Override
    public Boolean delete(Long imei) {
        return mobileRepository.delete(imei);
    }
}
