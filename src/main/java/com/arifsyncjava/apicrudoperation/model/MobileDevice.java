package com.arifsyncjava.apicrudoperation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity (name = "mobile_devices")
public class MobileDevice {

    private String brandName;
    private String modelName;
    @Id
    private Long imei;
}
