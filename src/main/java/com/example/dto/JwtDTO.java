package com.example.dto;

import com.example.enums.ProfileRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Alisher Odilov
 * Date: 27.03.2023
 */
@Getter
@Setter
@AllArgsConstructor
public class JwtDTO {
    private String email;
    private ProfileRole role;
}
