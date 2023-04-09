package com.example.dto;

import com.example.enums.ProfileRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Alisher Odilov
 * Date: 27.03.2023
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponseDTO {
    private String name;
    private String surname;
    private String email;
    private ProfileRole role;
    private String token;
}
