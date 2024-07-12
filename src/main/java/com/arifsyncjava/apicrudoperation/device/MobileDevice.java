package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.simcard.SimCard;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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


    @OneToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SimCard> simCardSet = new HashSet<>();

    public void addSimCardToMobile(SimCard simCard) {
        this.simCardSet.add(simCard);
    }


    public MobileDevice(MobileDeviceCreateRequest request) {
        this.brandName = request.getBrandName();
        this.modelName = request.getModelName();
    }


}
