package com.arifsyncjava.apicrudoperation.dto;

import com.arifsyncjava.apicrudoperation.model.SimCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
public class MobileDeviceDTO {
    private Long imei;
    private String brandName;
    private String modelName;
    private List<SimCard> simCards = new ArrayList<>();


}
