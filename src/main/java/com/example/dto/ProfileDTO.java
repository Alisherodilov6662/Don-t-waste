package com.example.dto;

import com.example.enums.ProfileRole;
import com.example.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.entity.ProfileEntity} entity
 */
@Data
public class ProfileDTO{
    private  Long id;
    @NotBlank(message = "Name should not be null ! ")
    private  String name;
    @NotBlank(message = "SurName should not be null ! ")
    private  String surname;
    @Email(message = "Email shoul be valid ! ")
    private  String email;
    //Todo
    private  String phone;
    //Todo o`zim validation yasayman
    private  String password;
    private  ProfileRole role;
    private  Status status;
    private  LocalDateTime createdDate;
    private  String attach_id;
}