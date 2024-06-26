package com.arifsyncjava.apicrudoperation.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter @Setter
 @AllArgsConstructor
@Entity(name = "mobile_devices")
public class MobileDevice {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long imei;
    private String brandName;
    private String modelName;

    @OneToMany
    private Set<SimCard> simCards =new HashSet<>();

    public MobileDevice() {
    }
}
