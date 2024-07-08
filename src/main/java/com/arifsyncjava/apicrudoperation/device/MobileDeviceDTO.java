package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.simcard.SimCard;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
public class MobileDeviceDTO {
    private Long imei;
    private String brandName;
    private String modelName;
    private List<SimCard> simCards ;


}
