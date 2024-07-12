package com.arifsyncjava.apicrudoperation.simcard;

import lombok.Getter;

@Getter
public class SimCardDTO {
    private String number;
    private String operatorName;

    public SimCardDTO (SimCard simCard) {
        this.number = simCard.getNumber();
        this.operatorName = simCard.getOperatorName();
    }


}
