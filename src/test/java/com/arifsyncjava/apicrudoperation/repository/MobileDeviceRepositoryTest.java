package com.arifsyncjava.apicrudoperation.repository;

import com.arifsyncjava.apicrudoperation.model.MobileDevice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ComponentScan (basePackages = "com.arifsyncjava.apicrudoperation")
@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class MobileDeviceRepositoryTest {


    private  MobileRepository mobileRepository;

    @Autowired
    public MobileDeviceRepositoryTest(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @Test
    public void  insertTest () {
        MobileDevice mobileDevice = new MobileDevice ();
        mobileDevice.setBrandName("xiaomi");
        mobileDevice.setModelName("redmi 7");
        MobileDevice savedDevice = mobileRepository.insert(mobileDevice);
        assertThat(savedDevice.getBrandName().equalsIgnoreCase("xiaomi"));

    }

    @Test
    public void findByImeiTest () {
        Long imei = 1L;
        MobileDevice mobileDevice = new MobileDevice ();
        mobileDevice.setBrandName("xiaomi");
        mobileDevice.setModelName("redmi 7");
        mobileRepository.insert(mobileDevice);
        Optional<MobileDevice> savedDevice = mobileRepository.selectById(imei);
        assertThat(savedDevice.get().getImei()).isGreaterThan(0L);


    }

    @Test
    public void updateTest () {
        Long imei = 1L;
        MobileDevice mobileDevice = new MobileDevice ();
        mobileDevice.setBrandName("xiaomi");
        mobileDevice.setModelName("redmi 7");
        mobileRepository.insert(mobileDevice);
        MobileDevice savedDevice = mobileRepository.selectById(imei).get();
        savedDevice.setModelName("nokia 10");
        assertThat(savedDevice.getModelName()).isEqualTo("nokia 10");


    }


    @Test
    public void deleteTest () {
        Long imei = 1L;
        MobileDevice mobileDevice = new MobileDevice ();
        mobileDevice.setBrandName("xiaomi");
        mobileDevice.setModelName("redmi 7");
        mobileRepository.insert(mobileDevice);
        mobileRepository.delete(imei);
        Optional<MobileDevice> savedDevice = mobileRepository.selectById(imei);
        assertThat(savedDevice).isEmpty();


    }







}
