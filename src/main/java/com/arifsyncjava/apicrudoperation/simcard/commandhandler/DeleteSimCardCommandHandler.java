package com.arifsyncjava.apicrudoperation.simcard.commandhandler;

import com.arifsyncjava.apicrudoperation.Command;
import com.arifsyncjava.apicrudoperation.dto.HttpResponse;
import com.arifsyncjava.apicrudoperation.exceptions.ResourceNotFoundException;
import com.arifsyncjava.apicrudoperation.simcard.SimCard;
import com.arifsyncjava.apicrudoperation.simcard.SimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DeleteSimCardCommandHandler implements
        Command<String, HttpResponse> {

    private final SimRepository simRepository;


    @Override
    public ResponseEntity<HttpResponse> execute(String number) {
        Optional<SimCard> optionalSimCard = simRepository.findById(number);
        if (optionalSimCard.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        simRepository.deleteById(number);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.NO_CONTENT,
                        null,
                        Map.of("deleted",true)
                ));
    }
}
