package com.arifsyncjava.apicrudoperation.service;

import com.arifsyncjava.apicrudoperation.dto.MobileDeviceDTO;

import java.util.Optional;

public interface MobileService {

    MobileDeviceDTO create (MobileDeviceDTO mobileDeviceDTO);
    MobileDeviceDTO readById (Long imei);
    MobileDeviceDTO update (Long imei, MobileDeviceDTO mobileDeviceDTO);
    void delete (Long imei);

}
