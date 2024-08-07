package com.microservice.ownerService.exception;

public class InternalServerException extends RuntimeException{
    public InternalServerException(String msg){
        super(msg);
    }

}
