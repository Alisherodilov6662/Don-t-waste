package com.example.service;

import com.example.dto.advert.AdvertSectionCreationDTO;
import com.example.entity.advert.AdvertSectionEntity;
import com.example.exceptions.AdvertSectionIsNotExist;
import com.example.exceptions.AdvertsSectionEntityAlreadyExistException;
import com.example.repository.AdvertSectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Author: Alisher Odilov
 * Date: 11.07.2023
 */
@Service
@AllArgsConstructor
public class AdvertSectionService {
    private final AdvertSectionRepository advertSectionRepository;

    public AdvertSectionCreationDTO create(AdvertSectionCreationDTO dto) {
        Optional<AdvertSectionEntity> optional = advertSectionRepository.findByName(dto.getName());
        if (optional.isPresent()) {
            throw new AdvertsSectionEntityAlreadyExistException("AdvertsSectionEntity is already exist ! ");
        }
        AdvertSectionEntity entity = toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setVisible(true);
        advertSectionRepository.save(entity);
        return dto;
    }
    public AdvertSectionCreationDTO update(AdvertSectionCreationDTO dto, Integer id) {
        Optional<AdvertSectionEntity> optional=advertSectionRepository.findById(id);
        if (optional.isEmpty()){
            throw new AdvertSectionIsNotExist(" such kind of advertSection is not exist ! ");
        }
        AdvertSectionEntity entity=optional.get();
        entity.setName(dto.getName());
        entity.setPhotoId(dto.getPhotoId());
        entity.setUpdatedDate(LocalDateTime.now());
        advertSectionRepository.save(entity);
        return dto;
    }

    public Boolean deleteById(Integer id) {
        Optional<AdvertSectionEntity> optional=advertSectionRepository.findById(id);
        if (optional.isEmpty()){
            throw new AdvertSectionIsNotExist("such kind of advertSection is not exist ! ");
        }
        advertSectionRepository.deleteById(id);
        return true;
    }

    private AdvertSectionEntity toEntity(AdvertSectionCreationDTO dto) {
        AdvertSectionEntity entity = new AdvertSectionEntity();
        entity.setName(dto.getName());
        entity.setPhotoId(dto.getPhotoId());
        return entity;
    }

}
