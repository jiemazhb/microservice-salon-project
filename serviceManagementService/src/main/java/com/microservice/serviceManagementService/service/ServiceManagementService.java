package com.microservice.serviceManagementService.service;

import com.microservice.serviceManagementService.model.ServiceRequest;
import com.microservice.serviceManagementService.model.ServiceResponse;

public interface ServiceManagementService {
    ServiceResponse addService(ServiceRequest serviceRequest);
}
