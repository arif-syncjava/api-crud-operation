package com.arifsyncjava.apicrudoperation.simcard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity (name = "simcards")
public class SimCard {
    private String operatorName;
    @Id
    private Integer number;

}
