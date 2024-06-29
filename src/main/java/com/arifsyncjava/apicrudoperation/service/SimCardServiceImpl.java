package com.arifsyncjava.apicrudoperation.service;

import com.arifsyncjava.apicrudoperation.exception.ResourceNotFoundException;
import com.arifsyncjava.apicrudoperation.model.SimCard;
import com.arifsyncjava.apicrudoperation.repository.SimCardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SimCardServiceImpl implements SimCardService{

    private final SimCardJpaRepository simRepository;

    @Override
    public SimCard create(SimCard simCard) {
        return simRepository.save(simCard);
    }

    @Override
    public SimCard getSimCardByNumber(Integer phoneNumber) {
        SimCard savedSimCard = simRepository
                .findById(phoneNumber)
                .orElseThrow(()-> new ResourceNotFoundException("SimCard Not Found"));
        return savedSimCard;
    }

    @Override
    public SimCard update(Integer phoneNumber, SimCard simCard) {
        SimCard savedSimCard = simRepository
                .findById(phoneNumber)
                .orElseThrow(()-> new ResourceNotFoundException("SimCard Not Found"));
        savedSimCard.setOperatorName(simCard.getOperatorName());
        savedSimCard.setNumber(simCard.getNumber());
        return simRepository.save(savedSimCard);
    }

    @Override
    public void delete(Integer phoneNumber) {
           simRepository.deleteById(phoneNumber);
    }
}
