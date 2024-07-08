package com.arifsyncjava.apicrudoperation.device.repository;

import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileJpaRepository extends JpaRepository<MobileDevice, Long> {
}
