package com.microservice.serviceManagementService.model;

import lombok.Data;

import java.time.Instant;
@Data
public class ServiceRequest {
    private long salonId;
    private String serviceName;
    private String description;
    private int price;
}
