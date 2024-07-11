package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
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
                        "   ","iphone 10 pro");


        InvalidException exception1 = assertThrows(InvalidException.class,
                ()->validator.validate(deviceRequest));

        assertEquals("Brand name required", exception1.getMessage());

        MobileDeviceCreateRequest deviceRequestNull =
                new MobileDeviceCreateRequest(
                        null ,"iphone 10 pro");

        InvalidException exception2 = assertThrows(InvalidException.class,
                ()->validator.validate(deviceRequest));

        assertEquals("Brand name required",exception2.getMessage() );


    }

    @Test
    void modelNameIsEmpty_returnsInvalidException() {
        MobileDeviceCreateRequest  deviceRequest =
                new MobileDeviceCreateRequest(
                        "Apple"," ");


        InvalidException exception1 = assertThrows(InvalidException.class,
                ()->validator.validate(deviceRequest));

        assertEquals("Model name required", exception1.getMessage());

        MobileDeviceCreateRequest exceptionForNull =
                new MobileDeviceCreateRequest(
                        "Apple",null);


        InvalidException exception2 = assertThrows(InvalidException.class,
                ()->validator.validate(exceptionForNull));

        assertEquals("Model name required",
                exception2.getMessage() );

    }



}





