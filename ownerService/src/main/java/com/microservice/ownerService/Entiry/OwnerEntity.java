package com.microservice.ownerService.Entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OwnerEntity {
    @Id
    private long id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private int experience;
//    private Salon salon;
}
