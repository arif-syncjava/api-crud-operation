package com.arifsyncjava.apicrudoperation.simcard.commandhandler;

import org.springframework.http.ResponseEntity;

public interface UpdateCommand <ID,Request,Response>{
    ResponseEntity<Response> execute (ID id,Request request);
}
