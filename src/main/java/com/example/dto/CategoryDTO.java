package com.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author: Alisher Odilov
 * Date: 28.03.2023
 */
@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private LocalDateTime createdDate;
}
