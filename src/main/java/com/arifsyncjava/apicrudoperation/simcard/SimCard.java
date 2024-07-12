package com.arifsyncjava.apicrudoperation.simcard;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity (name = "sim_cards")
public class SimCard {

    @Id
    private String number;
    private String operatorName;
    private String balance = "10 TK";



}
