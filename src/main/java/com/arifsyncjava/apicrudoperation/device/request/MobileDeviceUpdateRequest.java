package com.arifsyncjava.apicrudoperation.device.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class MobileDeviceUpdateRequest {
    private String imei;
    private MobileDeviceCreateRequest request;
}
