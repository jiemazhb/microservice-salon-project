package com.microservice.serviceManagementService.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Builder
@Data
public class ServiceResponse {
    private String serviceName;
    private String description;
    private int price;
    private Instant createAt;
}
