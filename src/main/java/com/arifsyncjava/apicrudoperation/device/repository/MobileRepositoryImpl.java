package com.arifsyncjava.apicrudoperation.device.repository;

import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class MobileRepositoryImpl implements MobileRepository {

    private final MobileJpaRepository repository;

    @Override
    public MobileDevice insert(MobileDevice mobile) {
        return repository.save(mobile);
    }

    @Override
    public Optional<MobileDevice> findById(Long imei) {
        return repository.findById(imei);
    }

    @Override
    public MobileDevice update(MobileDevice mobile) {
        return repository.save(mobile);
    }

    @Override
    public void deleteById(Long imei) {
      repository.deleteById(imei);
    }

}
