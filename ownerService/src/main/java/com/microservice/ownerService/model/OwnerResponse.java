package com.microservice.ownerService.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class OwnerResponse {
    private long id;
    private String name;
//    private String token;
}