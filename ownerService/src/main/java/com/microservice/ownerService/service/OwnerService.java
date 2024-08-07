package com.microservice.ownerService.service;

import com.microservice.ownerService.model.OwnerRequest;
import com.microservice.ownerService.model.OwnerResponse;

public interface OwnerService {
    void register(OwnerRequest ownerRequest);

    OwnerResponse login(OwnerRequest ownerRequest);
}
