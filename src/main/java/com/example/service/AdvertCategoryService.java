package com.example.service;

import com.example.dto.advert.AdvertCategoryCreationDTO;
import com.example.entity.advert.AdvertCategoryEntity;
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

    private AdvertCategoryRepository advertCategoryRepository;

    public AdvertCategoryCreationDTO create(AdvertCategoryCreationDTO dto) {
        Optional<AdvertCategoryEntity> optional=advertCategoryRepository.findByName(dto.getName());
        if(optional.isPresent()){
            throw new CategoryExistException(" such category exist");
        }
        AdvertCategoryEntity entity=new AdvertCategoryEntity();
        entiry
    }
}
