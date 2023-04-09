package com.example.service;

import com.example.repository.AdvertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Author: Alisher Odilov
 * Date: 03.04.2023
 */
@Service
@AllArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;
}
