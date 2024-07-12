package com.arifsyncjava.apicrudoperation.simcard.commandhandler;

import com.arifsyncjava.apicrudoperation.device.MobileDevice;
import com.arifsyncjava.apicrudoperation.device.MobileRepository;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.exceptions.InvalidException;
import com.arifsyncjava.apicrudoperation.exceptions.ResourceNotFoundException;
import com.arifsyncjava.apicrudoperation.simcard.SimCard;
import com.arifsyncjava.apicrudoperation.simcard.request.SimCardRequestValidator;
import com.arifsyncjava.apicrudoperation.simcard.SimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UpdateSimCardCommandHandler implements
        UpdateCommand <String,SimCard,HttpResponse> {

    private final SimRepository simRepository;
    private final MobileRepository mobileRepository;
    private final SimCardRequestValidator validator;

    @Override
    public ResponseEntity<HttpResponse> execute(String imei, SimCard simCard) {
        Optional<MobileDevice> optionalMobileDevice = mobileRepository.findById(imei);
        if (optionalMobileDevice.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        SimCard validatedSim = validator.validate(simCard);
        Set<SimCard> simCardSet = optionalMobileDevice.get().getSimCardSet();
        boolean exist = simCardSet.stream()
                .anyMatch(sim -> Objects.equals(simCard.getNumber(), validatedSim.getNumber()));
       SimCard sim ;
        if (exist) {
            Optional<SimCard> savedSim = simCardSet.stream()
                    .filter(s -> s.getNumber() == validatedSim.getNumber())
                    .findFirst();
             sim = savedSim.get();
            sim.setNumber(validatedSim.getNumber());
            sim.setOperatorName(validatedSim.getOperatorName());
        } else {
            throw new InvalidException("Number Invalid");
        }

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new HttpResponse(
                            HttpStatus.CREATED,
                            "Number Updated",
                            Map.of("simCard",sim)));
        }
    }

