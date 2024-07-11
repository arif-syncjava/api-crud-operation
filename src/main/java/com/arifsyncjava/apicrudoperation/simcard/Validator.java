package com.arifsyncjava.apicrudoperation.simcard;

import com.arifsyncjava.apicrudoperation.exceptions.InvalidException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Validator {

    public SimCard validate (SimCard simCard) {
        if (numberIsInvalid(simCard.getNumber())) {
            throw new InvalidException("Number invalid.Please enter a valid number");
        }
        if (operatorNameEmpty(simCard.getOperatorName())) {
            throw new InvalidException("Operator name required");
        }

        return simCard;

    }


    private boolean numberIsInvalid(String number) {
        int length = number.length();
        return length != 11;

    }


    private boolean operatorNameEmpty(String operatorName) {
        return !StringUtils.hasLength(operatorName);
    }




}
