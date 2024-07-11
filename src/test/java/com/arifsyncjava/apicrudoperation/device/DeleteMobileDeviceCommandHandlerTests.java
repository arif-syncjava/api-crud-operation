package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.commandhandler.DeleteMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteMobileDeviceCommandHandlerTests {

    @Mock
    private MobileRepository mobileRepository;

    private DeleteMobileDeviceCommandHandler deleteMobileDeviceCommandHandler;

    @BeforeEach
    void setup() {
        deleteMobileDeviceCommandHandler =
                new DeleteMobileDeviceCommandHandler(mobileRepository);
    }




    @Test
    void deleteMobileDeviceCommandHandler_returnsSuccess() {
        String imei = "12345";
        MobileDevice mobileDevice = new MobileDevice();
        mobileDevice.setImei(imei);

        when(mobileRepository.findById(imei)).thenReturn(Optional.of(mobileDevice));

        ResponseEntity<HttpResponse> responseEntity
                =deleteMobileDeviceCommandHandler.execute(imei);


        assertEquals( HttpStatus.NO_CONTENT.value(),
                responseEntity.getBody().getHttpCode());

    }

    @Test
    void deleteMobileDeviceCommandHandler_returnsException() {
        String imei = "12345";
        MobileDevice mobileDevice = new MobileDevice();
        mobileDevice.setImei(imei);


        when(mobileRepository.findById(imei)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class, ()->
                        deleteMobileDeviceCommandHandler.execute(imei));

        assertEquals( "Resource not found",
                exception.getMessage());






    }





}