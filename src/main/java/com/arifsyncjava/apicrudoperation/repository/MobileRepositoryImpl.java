package com.arifsyncjava.apicrudoperation.repository;

import com.arifsyncjava.apicrudoperation.model.MobileDevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MobileRepositoryImpl implements MobileRepository{

    private final MobileJpaRepository repository;


    @Override
    public MobileDevice insert(MobileDevice mobile) {
        return repository.save(mobile);
    }

    @Override
    public Optional<MobileDevice> selectById(Long imei) {
        return repository.findById(imei);
    }

    @Override
    public MobileDevice update(MobileDevice mobile) {
        return repository.save(mobile);
    }

    @Override
    public Boolean delete(Long imei) {
        if (repository.existsById(imei) ) {
            repository.deleteById(imei);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}