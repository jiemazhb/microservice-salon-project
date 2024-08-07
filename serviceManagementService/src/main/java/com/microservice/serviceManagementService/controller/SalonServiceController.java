package com.microservice.serviceManagementService.controller;

import com.microservice.serviceManagementService.model.ServiceRequest;
import com.microservice.serviceManagementService.model.ServiceResponse;
import com.microservice.serviceManagementService.service.ServiceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class SalonServiceController {
    @Autowired
    private ServiceManagementService serviceManagementService;
    @PostMapping("/addService")
    public ResponseEntity<ServiceResponse> addService(@RequestBody ServiceRequest ServiceRequest){
        ServiceResponse serviceResponse = this.serviceManagementService.addService(ServiceRequest);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
