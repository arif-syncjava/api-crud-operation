package com.arifsyncjava.apicrudoperation.repository;

import com.arifsyncjava.apicrudoperation.model.MobileDevice;

import java.util.Optional;

public interface MobileRepository {

    MobileDevice insert (MobileDevice mobile);
    Optional<MobileDevice> selectById (Long imei);
    MobileDevice update (MobileDevice mobile);
    void delete (Long imei);

}
