package com.example.dto;

import com.example.enums.ProfileRole;
import com.example.enums.Status;
import com.example.validation.validationInterface.ValidPhone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @ValidPhone //Todo o`zim yasadim ichiga kirib ko`ringlar
    private  String phone;
    @NotBlank
    @Size(max = 8, min = 8, message = "charachter should be 8 !")
    private  String password;
    private  ProfileRole role;
    private  Status status;
    private  LocalDateTime createdDate;
    private  String attach_id;
}