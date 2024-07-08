package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.AlternativeJdkIdGenerator;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "mobile_devices")
public class MobileDevice {
    @Id
    private String imei = new AlternativeJdkIdGenerator().generateId().toString();
    private String brandName;
    private String modelName;

    public MobileDevice (MobileDeviceCreateRequest request) {
        this.brandName = request.getBrandName();
        this.modelName = request.getModelName();
    }


}
