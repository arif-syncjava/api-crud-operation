package com.arifsyncjava.apicrudoperation.device;

import com.arifsyncjava.apicrudoperation.device.request.MobileDeviceCreateRequest;
import com.arifsyncjava.apicrudoperation.exceptions.InvalidException;
import org.springframework.util.StringUtils;

public class Validator {

    public static MobileDevice validate (MobileDeviceCreateRequest request) {

        if (brandNameIsEmpty(request.getBrandName())) {
            throw new InvalidException("Brand name required");
        }

        if (modelNameIsEmpty(request.getModelName())) {
            throw new InvalidException("Model name required");
        }

        return new MobileDevice(request);

    }

    private static boolean brandNameIsEmpty(String brandName) {
        return !StringUtils.hasLength(brandName);
    }

    private static boolean modelNameIsEmpty(String modelName) {
        return !StringUtils.hasLength(modelName);
    }


}
