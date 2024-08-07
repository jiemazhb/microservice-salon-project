package com.microservice.serviceManagementService.service;

import com.microservice.serviceManagementService.entity.SalonServiceEntity;
import com.microservice.serviceManagementService.exception.ConflictException;
import com.microservice.serviceManagementService.exception.InternalServerException;
import com.microservice.serviceManagementService.model.ServiceRequest;
import com.microservice.serviceManagementService.model.ServiceResponse;
import com.microservice.serviceManagementService.repository.ServiceManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


@Service
public class ServiceManagementImpl implements ServiceManagementService{
    @Autowired
    private ServiceManagementRepository serviceManagementRepository;
    @Override
    public ServiceResponse addService(ServiceRequest serviceRequest) {
        if(this.serviceManagementRepository.findByServiceName(serviceRequest.getServiceName()).isPresent()){
            throw new ConflictException("can not repeatedly add same service");
        }
        try {
            SalonServiceEntity salonServiceEntity = SalonServiceEntity.builder()
                    .salonId(serviceRequest.getSalonId())
                    .serviceName(serviceRequest.getServiceName())
                    .description(serviceRequest.getDescription())
                    .createAt(Instant.now())
                    .price(serviceRequest.getPrice())
                    .build();

            this.serviceManagementRepository.save(salonServiceEntity);


            ServiceResponse serviceResponse = ServiceResponse.builder()
                    .serviceName(serviceRequest.getServiceName())
                    .price(serviceRequest.getPrice())
                    .description(serviceRequest.getDescription())
                    .build();

            return serviceResponse;
        }catch (Exception e){
            throw new InternalServerException("add service error");
        }

    }
}
