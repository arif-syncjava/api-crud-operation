package com.arifsyncjava.apicrudoperation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MobileDeviceDTO {
    private String brandName;
    private String modelName;
    private Long imei;

}
