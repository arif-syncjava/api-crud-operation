package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.exceptions.InvalidException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MobileDeviceRequestValidator {

    public  MobileDevice validate(MobileDeviceCreateRequest request) {

        if (brandNameIsEmpty(request.getBrandName())) {
            throw new InvalidException("Brand name required");
        }

        if (modelNameIsEmpty(request.getModelName())) {
            throw new InvalidException("Model name required");
        }

        return new MobileDevice(request);

    }

    private  boolean brandNameIsEmpty(String brandName) {
        return !StringUtils.hasText(brandName);
    }

    private  boolean modelNameIsEmpty(String modelName) {
        return !StringUtils.hasText(modelName);
    }


}
