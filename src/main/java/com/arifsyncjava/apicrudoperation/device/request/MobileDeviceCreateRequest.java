package com.arifsyncjava.apicrudoperation.device.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class MobileDeviceCreateRequest {
    private String brandName;
    private String modelName;

}
