package com.arifsyncjava.apicrudoperation.service;

import com.arifsyncjava.apicrudoperation.model.SimCard;

public interface SimCardService {
    SimCard create (Long imei, SimCard simCard);
    SimCard getSimCardByNumber (Integer phoneNumber);
    SimCard update (Integer phoneNumber, SimCard simCard);
    void delete (Integer phoneNumber);
}
