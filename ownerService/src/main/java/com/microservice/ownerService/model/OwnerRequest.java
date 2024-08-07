package com.microservice.ownerService.model;

import lombok.Data;

@Data
public class OwnerRequest {
    private String name;
    private String gender;
    private String phone;
    private String email;
    private int experience;
}
