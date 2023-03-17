package com.example.dto;

import com.example.enums.Role;
import com.example.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.entity.ProfileEntity} entity
 */
@Data
public class ProfileDTO{
    private  Long id;
    private  String name;
    private  String surname;
    private  String email;
    private  String phone;
    private  String password;
    private  Role role;
    private  Status status;
    private  LocalDateTime createdDate;
    private  String attach_id;
}