package com.example.service;

import com.example.dto.advert.AdvertCategoryCreationDTO;
import com.example.entity.advert.AdvertCategoryEntity;
import com.example.enums.Language;
import com.example.exceptions.CategoryExistException;
import com.example.repository.AdvertCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023
 */

@Service
@AllArgsConstructor
public class AdvertCategoryService {

    private final AdvertCategoryRepository advertCategoryRepository;
    private final ResourceBundleService resourceBundleService;

    public AdvertCategoryCreationDTO create(AdvertCategoryCreationDTO dto, Language language) {
        Optional<AdvertCategoryEntity> optional=advertCategoryRepository.findByName(dto.getName());
        if(optional.isPresent()){
            throw new CategoryExistException(resourceBundleService.getMessage("item.exist", language.name()));
        }
        AdvertCategoryEntity entity=new AdvertCategoryEntity();

    }
}
