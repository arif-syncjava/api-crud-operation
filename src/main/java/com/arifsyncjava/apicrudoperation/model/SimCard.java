package com.arifsyncjava.apicrudoperation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
