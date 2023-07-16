package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachResponseDTO {
    private String id;
    private String originalName;
    private String path;
    private Long size;
    private String type;
    private LocalDateTime createdData;
    private String url;
}
