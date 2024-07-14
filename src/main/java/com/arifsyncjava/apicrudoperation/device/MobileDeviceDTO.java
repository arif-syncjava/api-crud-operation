package com.arifsyncjava.apicrudoperation.device;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MobileDeviceDTO {
    @JsonProperty("Brand")
    private String brandName;
    @JsonProperty("Model")
    private String modelName;
    @JsonProperty("IMEI-Number")
    private String imei;



    public MobileDeviceDTO (MobileDevice mobileDevice) {
        this.brandName = mobileDevice.getBrandName();
        this.modelName = mobileDevice.getModelName();
        this.imei = mobileDevice.getImei();

    }


}
