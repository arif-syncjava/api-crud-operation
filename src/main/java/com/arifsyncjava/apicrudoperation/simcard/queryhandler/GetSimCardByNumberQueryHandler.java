package com.arifsyncjava.apicrudoperation.simcard.queryhandler;

import com.arifsyncjava.apicrudoperation.Query;
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
public class GetSimCardByNumberQueryHandler implements
        Query<String, HttpResponse> {

    private final SimRepository simRepository;

    @Override
    public ResponseEntity<HttpResponse> execute(String number) {
        Optional<SimCard> optionalSimCard = simRepository
                .findById(Integer.valueOf(number));
        if (optionalSimCard.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        SimCard simCard = optionalSimCard.get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new HttpResponse(
                        HttpStatus.OK,
                        null,
                        Map.of(simCard,simCard)));

    }
}
