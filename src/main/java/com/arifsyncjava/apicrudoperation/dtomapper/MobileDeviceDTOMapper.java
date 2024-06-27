package com.arifsyncjava.apicrudoperation.dtomapper;

import com.arifsyncjava.apicrudoperation.dto.MobileDeviceDTO;
import com.arifsyncjava.apicrudoperation.model.MobileDevice;
import org.springframework.beans.BeanUtils;

public class MobileDeviceDTOMapper {

    public static MobileDeviceDTO convertToDTO (MobileDevice mobileDevice) {
        MobileDeviceDTO mobileDeviceDTO = new MobileDeviceDTO();
        BeanUtils.copyProperties(mobileDevice, mobileDeviceDTO);
        return mobileDeviceDTO;
    }

    public static MobileDevice convertToModel (MobileDeviceDTO mobileDeviceDTO) {
        MobileDevice mobileDevice = new MobileDevice();
        BeanUtils.copyProperties(mobileDeviceDTO, mobileDevice);
        return mobileDevice;
    }



}
