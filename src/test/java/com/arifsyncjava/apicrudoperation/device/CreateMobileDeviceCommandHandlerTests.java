package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.commandhandler.CreateMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceRequestValidator;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class CreateMobileDeviceCommandHandlerTests {


    @Mock
    private  MobileRepository mobileRepository;

    @Mock
    private MobileDeviceRequestValidator mobileDeviceRequestValidator;

    @InjectMocks
    private  CreateMobileDeviceCommandHandler
            createMobileDeviceCommandHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void createMobileDeviceCommandHandler_returnsSuccess () {
        MobileDeviceCreateRequest deviceCreateRequest =
                new MobileDeviceCreateRequest("Nokia","Note 9 pro");
        MobileDevice mobileDevice =
                new MobileDevice("12345","Nokia","Note 9 pro");

        when(mobileDeviceRequestValidator.validate(deviceCreateRequest)).thenReturn(mobileDevice);
        when(mobileRepository.save(mobileDevice)).thenReturn(mobileDevice);



        ResponseEntity<HttpResponse> responseEntity =
                createMobileDeviceCommandHandler.execute(deviceCreateRequest);


        assertEquals("Resource created successfully",
                responseEntity.getBody().getMessage());

    }





    }









