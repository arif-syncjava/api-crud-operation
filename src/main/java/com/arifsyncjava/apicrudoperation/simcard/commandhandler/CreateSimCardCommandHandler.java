package com.arifsyncjava.apicrudoperation.simcard.commandhandler;

import com.arifsyncjava.apicrudoperation.Command;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.simcard.SimCard;
import com.arifsyncjava.apicrudoperation.simcard.SimRepository;
import com.arifsyncjava.apicrudoperation.simcard.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class CreateSimCardCommandHandler implements
        Command<SimCard, HttpResponse> {

    private final SimRepository simRepository;
    private final Validator validator;

    @Override
    public ResponseEntity<HttpResponse> execute(SimCard simCard) {
        SimCard validatedSim = validator.validate(simCard);
        SimCard savedSim = simRepository.save(validatedSim);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new HttpResponse(
                        HttpStatus.CREATED,
                        "Resource Created",
                        Map.of("simCard",savedSim)));
    }

}
