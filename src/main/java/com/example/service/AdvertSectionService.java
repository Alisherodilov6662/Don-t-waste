package com.example.service;

import com.example.dto.advert.AdvertSectionGetDTO;
import com.example.dto.advert.AdvertSectionCreationDTO;
import com.example.entity.advert.AdvertSectionEntity;
import com.example.enums.Language;
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
    private final ResourceBundleService resourceBundleService;

    public AdvertSectionCreationDTO create(AdvertSectionCreationDTO dto, Language language) {
        Optional<AdvertSectionEntity> optional = advertSectionRepository.findByName(dto.getName());
        if (optional.isPresent()) {
            throw new AdvertsSectionEntityAlreadyExistException(resourceBundleService.getMessage("advertsection.exist", language.name()));
        }
        AdvertSectionEntity entity = toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setVisible(true);
        advertSectionRepository.save(entity);
        return dto;
    }
    public AdvertSectionCreationDTO update(AdvertSectionCreationDTO dto, Integer id, Language language) {
        Optional<AdvertSectionEntity> optional=advertSectionRepository.findById(id);
        if (optional.isEmpty()){
            throw new AdvertSectionIsNotExist(resourceBundleService.getMessage("advertsection.not.exist", language.name()));
        }
        AdvertSectionEntity entity=optional.get();
        entity.setName(dto.getName());
        entity.setPhotoId(dto.getPhotoId());
        entity.setUpdatedDate(LocalDateTime.now());
        advertSectionRepository.save(entity);
        return dto;
    }

    public Boolean deleteById(Integer id, Language language) {
        Optional<AdvertSectionEntity> optional=advertSectionRepository.findById(id);
        if (optional.isEmpty()){
            throw new AdvertSectionIsNotExist(resourceBundleService.getMessage("advertsection.not.exist", language.name()));
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

    public AdvertSectionGetDTO getById(Integer id, Language language) {
        Optional<AdvertSectionEntity> optional=advertSectionRepository.findById(id);
        if (optional.isEmpty()){
            throw new AdvertSectionIsNotExist(resourceBundleService.getMessage("advertsection.not.exist", language.name()));
        }
        AdvertSectionGetDTO dto=toDTO(optional.get());
        return dto;
    }

    private AdvertSectionGetDTO toDTO(AdvertSectionEntity advertSectionEntity) {
        AdvertSectionGetDTO dto=new AdvertSectionGetDTO();
        dto.setName(advertSectionEntity.getName());
        dto.setPhotoId(advertSectionEntity.getPhotoId());
        dto.setCreatedDate(advertSectionEntity.getCreatedDate());
        dto.setUpdatedDate(advertSectionEntity.getUpdatedDate());
        dto.setId(advertSectionEntity.getId());
        return dto;
    }
}
