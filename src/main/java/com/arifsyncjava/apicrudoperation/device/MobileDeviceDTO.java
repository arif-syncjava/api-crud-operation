package com.arifsyncjava.apicrudoperation.device;


import com.arifsyncjava.apicrudoperation.simcard.SimCard;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class MobileDeviceDTO {
    @JsonProperty("Brand")
    private String brandName;
    @JsonProperty("Model")
    private String modelName;
    @JsonProperty("IMEI-Number")
    private String imei;

    private Set<SimCard> simCardSet;

    public MobileDeviceDTO (MobileDevice mobileDevice) {
        this.brandName = mobileDevice.getBrandName();
        this.modelName = mobileDevice.getModelName();
        this.imei = mobileDevice.getImei();
        this.simCardSet = mobileDevice.getSimCardSet();
    }


}
