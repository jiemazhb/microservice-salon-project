package com.microservice.ownerService.model;

//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OwnerRequest {
//    @NotBlank(message = "Enter your name")
    private String name;
    private String gender;
    private String phone;
//    @Email(message = "Email should be valid")
//    @NotBlank(message = "Email is mandatory")
    private String email;
//    @NotBlank(message = "please enter your password")
    private String password;
    private int experience;
}
