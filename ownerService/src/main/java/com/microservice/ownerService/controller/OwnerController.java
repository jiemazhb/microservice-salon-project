package com.microservice.ownerService.controller;

import com.microservice.ownerService.model.OwnerRequest;
import com.microservice.ownerService.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;
    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> ownerRegister(@RequestBody OwnerRequest ownerRequest){

        this.ownerService.register(ownerRequest);
        return new ResponseEntity("Congratulations, Register Successfully!", HttpStatus.CREATED);

    }
}
