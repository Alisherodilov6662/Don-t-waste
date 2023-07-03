package com.example.dto.advert;

import com.example.entity.advert.AdvertCategoryEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link AdvertCategoryEntity} entity
 */
@Data
public class AdvertSectionCreationDTO {

    private String name;
    private String photoId;

}