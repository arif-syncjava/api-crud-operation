package com.arifsyncjava.apicrudoperation.service;

import com.arifsyncjava.apicrudoperation.dto.MobileDeviceDTO;

import java.util.Optional;

public interface MobileService {

    MobileDeviceDTO create (MobileDeviceDTO mobileDeviceDTO);
    Optional<MobileDeviceDTO> readById (Long imei);
    MobileDeviceDTO update (MobileDeviceDTO mobileDeviceDTO);
    Boolean delete (Long imei);

}
