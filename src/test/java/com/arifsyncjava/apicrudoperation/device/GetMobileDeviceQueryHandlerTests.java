package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.queryhandler.GetMobileDeviceQueryHandler;
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
public class GetMobileDeviceQueryHandlerTests {

    @Mock
    private  MobileRepository mobileRepository;
    private GetMobileDeviceQueryHandler getMobileDeviceQueryHandler;

    @BeforeEach
    void setup() {
        getMobileDeviceQueryHandler =
                new GetMobileDeviceQueryHandler(mobileRepository);
    }

    @Test
    void getMobileDeviceQueryHandler_returnsSuccess() {

        String imei = "5";
        MobileDevice mobileDevice = new MobileDevice();
        mobileDevice.setImei(imei);

        when(mobileRepository.findById(imei)).thenReturn(Optional.of(mobileDevice));

        ResponseEntity<HttpResponse> responseEntity =
                getMobileDeviceQueryHandler.execute(imei);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    void getMobileDeviceQueryHandler_returnsException() {

        String imei = "5";
        MobileDevice mobileDevice = new MobileDevice();
        mobileDevice.setImei(imei);

        when(mobileRepository.findById(imei)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                ()->getMobileDeviceQueryHandler.execute(imei));


        assertEquals("Resource not found", exception.getMessage());

    }






}
