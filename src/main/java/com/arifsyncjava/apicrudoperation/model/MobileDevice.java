package com.arifsyncjava.apicrudoperation.model;

import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity(name = "mobile_devices")
public class MobileDevice {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long imei;
    private String brandName;
    private String modelName;


}
