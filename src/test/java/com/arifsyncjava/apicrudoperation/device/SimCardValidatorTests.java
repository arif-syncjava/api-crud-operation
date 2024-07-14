package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceRequestValidator;
import com.arifsyncjava.apicrudoperation.exceptions.InvalidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimCardValidatorTests {

    private MobileDeviceRequestValidator validator;

    @BeforeEach
    void setup() {
        validator = new MobileDeviceRequestValidator();
    }

    @Test
    void brandNameIsEmpty_returnsInvalidException() {
        MobileDeviceCreateRequest deviceRequest =
                new MobileDeviceCreateRequest(
                        "12345","   ","iphone 10 pro");


        InvalidException exception1 = assertThrows(InvalidException.class,
                ()->validator.validate(deviceRequest));

        assertEquals("Brand name required", exception1.getMessage());

        InvalidException exception2 = assertThrows(InvalidException.class,
                ()->validator.validate(deviceRequest));

        assertEquals("Brand name required",exception2.getMessage() );

    }

    @Test
    void modelNameIsEmpty_returnsInvalidException() {
        MobileDeviceCreateRequest  deviceRequest =
                new MobileDeviceCreateRequest(
                        "12345","Apple"," ");


        InvalidException exception1 = assertThrows(InvalidException.class,
                ()->validator.validate(deviceRequest));

        assertEquals("Model name required", exception1.getMessage());

        MobileDeviceCreateRequest exceptionForNull =
                new MobileDeviceCreateRequest(
                        "12345","Apple",null);


        InvalidException exception2 = assertThrows(InvalidException.class,
                ()->validator.validate(exceptionForNull));

        assertEquals("Model name required",
                exception2.getMessage() );

    }



}





