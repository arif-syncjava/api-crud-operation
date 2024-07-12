package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.commandhandler.UpdateMobileDeviceCommandHandler;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceRequestValidator;
import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceUpdateRequest;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class updateMobileDeviceCommandHandlerTests {

    @Mock
    private MobileRepository mobileRepository;

    @Mock
    private MobileDeviceRequestValidator mobileDeviceRequestValidator;

    @InjectMocks
    private UpdateMobileDeviceCommandHandler updateMobileDeviceCommandHandler;

    @InjectMocks
    private UpdateMobileDeviceCommandHandlerV2 updateMobileDeviceCommandHandlerV2;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void updateMobileDeviceCommandHandler_returnsSuccess () {
        String imei = "123";

        MobileDeviceCreateRequest updateRequest =
                new MobileDeviceCreateRequest("Nokia","Note 9 pro");

        MobileDeviceUpdateRequest deviceUpdateRequest =
                new MobileDeviceUpdateRequest(imei,updateRequest);

        MobileDevice mobileDevice =
                new MobileDevice("123","Nokia","Note 9 pro");

        when(mobileRepository.findById(imei)).thenReturn(Optional.of(mobileDevice));
        when(mobileDeviceRequestValidator.validate(deviceUpdateRequest.getRequest())).thenReturn(mobileDevice);
        when(mobileRepository.save(mobileDevice)).thenReturn(mobileDevice);

        ResponseEntity<HttpResponse> responseEntity =
               updateMobileDeviceCommandHandler.execute(deviceUpdateRequest);


        assertEquals("Resource updated",
                responseEntity.getBody().getMessage());


    }


    @Test
    void updateMobileDeviceCommandHandlerV2_returnsException () {
        String imei = "123";
        MobileDeviceCreateRequest updateRequest =
                new MobileDeviceCreateRequest("Nokia","Note 9 pro");

        MobileDevice mobileDevice =
                new MobileDevice("123","Nokia","Note 9 pro");

        when(mobileRepository.findById(imei)).thenReturn(Optional.of(mobileDevice));
        when(mobileDeviceRequestValidator.validate(updateRequest)).thenReturn(mobileDevice);
        when(mobileRepository.save(mobileDevice)).thenReturn(mobileDevice);

        ResponseEntity<HttpResponse> responseEntity =
                updateMobileDeviceCommandHandlerV2.execute(imei, updateRequest);


        assertEquals("Resource updated",
                responseEntity.getBody().getMessage());


    }




}
