package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.simcard.SimCard;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter @Setter
 @NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mobile_devices")
public class MobileDevice {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long imei;
    private String brandName;
    private String modelName;
    @OneToMany (orphanRemoval = true)
    private Set<SimCard> simCards =new HashSet<>();

    public void addSimCardToDevice (SimCard simCard) {
        this.simCards.add(simCard);
    }
//
//    public MobileDevice() {
//    }
}
