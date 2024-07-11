package com.arifsyncjava.apicrudoperation.simcard;

import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.simcard.commandhandler.CreateSimCardCommandHandler;
import com.arifsyncjava.apicrudoperation.simcard.commandhandler.DeleteSimCardCommandHandler;
import com.arifsyncjava.apicrudoperation.simcard.queryhandler.GetSimCardByNumberQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping (path = "/simcards")
@RestController
public class SimCardController {

    private final CreateSimCardCommandHandler createSimCardCommandHandler;
    private final GetSimCardByNumberQueryHandler getSimCardByNumberQueryHandler;
    private final DeleteSimCardCommandHandler deleteSimCardCommandHandler;

    @PostMapping
    public ResponseEntity<HttpResponse> createSim (@RequestBody SimCard simCard) {
        return createSimCardCommandHandler.execute(simCard);
    }

    @GetMapping (path = "/{number}")
    public ResponseEntity<HttpResponse> findSimCardByNumber (
            @PathVariable("number") String number) {
        return getSimCardByNumberQueryHandler.execute(number);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateSimCard (
            @RequestBody SimCard simCard) {
        return null;
    }

    @DeleteMapping (path = "/{number}")
    public ResponseEntity<HttpResponse> deleteSimCardByNumber (
            @PathVariable("number") String number) {
        return deleteSimCardCommandHandler.execute(number);
    }






}