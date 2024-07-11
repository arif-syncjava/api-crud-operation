package com.arifsyncjava.apicrudoperation.simcard.commandhandler;

import com.arifsyncjava.apicrudoperation.Command;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.simcard.SimCard;
import com.arifsyncjava.apicrudoperation.simcard.SimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateSimCardCommandHandler implements
        Command<SimCard, HttpResponse> {

    private final SimRepository simRepository;


    @Override
    public ResponseEntity<HttpResponse> execute(SimCard simCard) {
        return null;
    }
}
