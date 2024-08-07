package com.microservice.ownerService.service;

import com.microservice.ownerService.Entiry.OwnerEntity;
import com.microservice.ownerService.exception.ConflictException;
import com.microservice.ownerService.exception.InternalServerException;
import com.microservice.ownerService.exception.NotFoundException;
import com.microservice.ownerService.exception.ValidationException;
import com.microservice.ownerService.model.OwnerRequest;
import com.microservice.ownerService.model.OwnerResponse;
import com.microservice.ownerService.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, PasswordEncoder passwordEncoder){
        this.ownerRepository = ownerRepository;
        this.passwordEncoder = passwordEncoder;
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
                    .password(passwordEncoder.encode(ownerRequest.getPassword()))
                    .experience(ownerRequest.getExperience())
                    .build();

            this.ownerRepository.save(ownerEntity);
        }catch (DataAccessException e){
            throw new InternalServerException("Register failed!");
        }
    }

    @Override
    public OwnerResponse login(OwnerRequest ownerRequest) {

        OwnerEntity ownerEntity = this.ownerRepository
                .findByEmail(ownerRequest.getEmail())
                .orElseThrow(() -> new NotFoundException("User name does not exist"));

        boolean isMatch = this.passwordEncoder.matches(ownerRequest.getPassword(), ownerEntity.getPassword());

        if(isMatch){
//             String token = generateJwtToken(ownerEntity);
             OwnerResponse userResponse = OwnerResponse.builder()
                     .id(ownerEntity.getId())
                     .name(ownerRequest.getName())
//                     .token(token)
                     .build();
             return userResponse;
        }else{
            throw new ValidationException("password does not match");
        }
    }
//    private String generateJwtToken(OwnerEntity ownerEntity) {
//        return Jwts.builder()
//                .setSubject(ownerEntity.getEmail())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1天
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
}
