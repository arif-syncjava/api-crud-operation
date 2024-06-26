package com.arifsyncjava.apicrudoperation.repository;

import com.arifsyncjava.apicrudoperation.model.MobileDevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MobileRepositoryImpl implements MobileRepository{




    @Override
    public MobileDevice insert(MobileDevice mobile) {
        return null;
    }

    @Override
    public MobileDevice selectById(Long imei) {
        return null;
    }

    @Override
    public MobileDevice update(MobileDevice mobile) {
        return null;
    }

    @Override
    public Boolean delete(Long imei) {
        return null;
    }
}
