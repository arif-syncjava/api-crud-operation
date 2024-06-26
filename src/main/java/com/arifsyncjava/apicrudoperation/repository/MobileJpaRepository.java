package com.arifsyncjava.apicrudoperation.repository;

import com.arifsyncjava.apicrudoperation.model.MobileDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileJpaRepository extends JpaRepository<MobileDevice, Long> {
}
