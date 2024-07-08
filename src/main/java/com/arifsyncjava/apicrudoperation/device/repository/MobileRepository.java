package com.arifsyncjava.apicrudoperation.device.repository;

import com.arifsyncjava.apicrudoperation.device.MobileDevice;

import java.util.Optional;

public interface MobileRepository {

    MobileDevice insert (MobileDevice mobile);
    Optional<MobileDevice> findById(Long imei);
    MobileDevice update (MobileDevice mobile);
    void deleteById (Long imei);

}
