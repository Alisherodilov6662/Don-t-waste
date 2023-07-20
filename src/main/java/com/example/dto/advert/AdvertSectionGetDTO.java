package com.example.dto.advert;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.entity.advert.AdvertSectionEntity} entity
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvertSectionGetDTO {
    private  Integer id;
    private  String name;
    private  String photoId;
    private  LocalDateTime createdDate;
    private  LocalDateTime updatedDate;
}