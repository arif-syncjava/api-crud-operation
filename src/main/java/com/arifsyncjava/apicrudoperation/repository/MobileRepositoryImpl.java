package com.arifsyncjava.apicrudoperation.repository;

import com.arifsyncjava.apicrudoperation.model.MobileDevice;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public class MobileRepositoryImpl implements MobileRepository{

    private final MobileJpaRepository repository;

    public MobileRepositoryImpl(MobileJpaRepository repository) {
        this.repository = repository;
    }


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
    public void delete(Long imei) {
      repository.deleteById(imei);
    }

}
