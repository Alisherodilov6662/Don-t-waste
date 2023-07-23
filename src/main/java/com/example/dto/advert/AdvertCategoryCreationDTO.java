package com.example.dto.advert;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Author: Alisher Odilov
 * Date: 19.07.2023
 */
@Data
public class AdvertCategoryCreationDTO {
    @NotBlank(message = "Name should not be empty ! ")
    private String name;
    private String photoId;
}
