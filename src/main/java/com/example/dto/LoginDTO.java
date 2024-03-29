package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Alisher Odilov
 * Date: 27.03.2023
 */
@Getter
@Setter
public class LoginDTO {
    @NotBlank(message = "Password should not be empty !")
    private String password;
    @NotBlank(message = "Email should not be empty ! ")
    private String email;
}
