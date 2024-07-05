package com.arifsyncjava.apicrudoperation.service;

import com.arifsyncjava.apicrudoperation.dto.MobileDeviceDTO;

public interface MobileService {

    MobileDeviceDTO create (MobileDeviceDTO mobileDeviceDTO);
    MobileDeviceDTO findById(Long imei);
    MobileDeviceDTO update (Long imei, MobileDeviceDTO mobileDeviceDTO);
    void delete (Long imei);

}
