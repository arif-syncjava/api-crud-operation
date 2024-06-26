package com.arifsyncjava.apicrudoperation.repository;

import com.arifsyncjava.apicrudoperation.model.MobileDevice;

public interface MobileRepository {

    MobileDevice insert (MobileDevice mobile);
    MobileDevice selectById (Long imei);
    MobileDevice update (MobileDevice mobile);
    Boolean delete (Long imei);

}
