package com.microservice.ownerService.service;

import com.microservice.ownerService.model.OwnerRequest;

public interface OwnerService {
    void register(OwnerRequest ownerRequest);
}
