package com.arifsyncjava.apicrudoperation.simcard;

import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.simcard.commandhandler.CreateSimCardCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping (path = "/simcards")
@RestController
public class SimCardController {

    private final CreateSimCardCommandHandler createSimCardCommandHandler;

    @PostMapping
    public ResponseEntity<HttpResponse> createSim (@RequestBody SimCard simCard) {
        return createSimCardCommandHandler.execute(simCard);
    }




}