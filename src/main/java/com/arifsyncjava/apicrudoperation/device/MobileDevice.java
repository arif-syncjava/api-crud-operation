package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mobile_devices")
public class MobileDevice {

    @Id
    private String imei;
    private String brandName;
    private String modelName;

    public MobileDevice(MobileDeviceCreateRequest request) {
        this.brandName = request.getBrandName();
        this.modelName = request.getModelName();
    }


}
