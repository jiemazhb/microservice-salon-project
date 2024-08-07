package com.microservice.serviceManagementService.exception;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String msg){
        super(msg);
    }

}
