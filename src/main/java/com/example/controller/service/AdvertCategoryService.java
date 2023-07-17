package com.example.controller.service;

import com.example.repository.AdvertCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023
 */

@Service
@AllArgsConstructor
public class AdvertCategoryService {

    private AdvertCategoryRepository advertCategoryRepository;
}
