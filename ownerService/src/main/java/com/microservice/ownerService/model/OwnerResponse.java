package com.microservice.ownerService.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OwnerResponse {
    private String id;
    private String name;
//    private String token;
}