package com.microservice.ownerService.service;

import com.microservice.ownerService.Entiry.OwnerEntity;
import com.microservice.ownerService.exception.ConflictException;
import com.microservice.ownerService.exception.InternalServerException;
import com.microservice.ownerService.model.OwnerRequest;
import com.microservice.ownerService.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;
    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }
    @Override
    public void register(OwnerRequest ownerRequest) {

        if (this.ownerRepository.findByEmail(ownerRequest.getEmail()).isPresent()){
            throw new ConflictException("The email has already been registered!");
        }

        try {
            OwnerEntity ownerEntity = OwnerEntity.builder()
                    .name(ownerRequest.getName())
                    .phone(ownerRequest.getPhone())
                    .gender(ownerRequest.getGender())
                    .email(ownerRequest.getEmail())
                    .experience(ownerRequest.getExperience())
                    .build();

            this.ownerRepository.save(ownerEntity);
        }catch (DataAccessException e){
            throw new InternalServerException("Register failed!");
        }
    }
}
