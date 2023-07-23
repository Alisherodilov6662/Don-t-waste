package com.example.dto.advert;

import com.example.entity.advert.AdvertCategoryEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link AdvertCategoryEntity} entity
 */
@Data
public class AdvertSectionCreationDTO {

    @NotBlank(message = "Name should not be null ! ")
    private String name;
    private String photoId;

}