package com.arifsyncjava.apicrudoperation.service;

import com.arifsyncjava.apicrudoperation.dto.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.exception.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException(" Resource Not Found"));
        return convertToDTO(mobileDevice);
    }

    @Override
    public MobileDeviceDTO update(Long imei, MobileDeviceDTO mobileDeviceDTO) {
        MobileDevice mobileDevice = mobileRepository
                .selectById(imei)
                .orElseThrow(() -> new ResourceNotFoundException(" Resource Not Found"));
        mobileDevice.setBrandName(mobileDeviceDTO.getBrandName());
        mobileDevice.setModelName(mobileDeviceDTO.getModelName());
        MobileDevice updatedDevice = mobileRepository.insert(mobileDevice);
        return convertToDTO(updatedDevice);

    }

    @Override
    public void delete(Long imei) {
        mobileRepository
                .selectById(imei)
                .orElseThrow(() -> new ResourceNotFoundException(" Resource Not Found"));
        mobileRepository.delete(imei);


    }
}
