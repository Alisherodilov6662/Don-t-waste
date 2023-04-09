package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.entity.CategoryEntity;
import com.example.exceptions.CategoryNotFoundException;
import com.example.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Author: Alisher Odilov
 * Date: 30.03.2023
 */
@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDTO create(CategoryDTO dto) {
        CategoryEntity entity=new CategoryEntity();
        entity.setName(dto.getName());
        entity.setCreatedDate(LocalDateTime.now());
        categoryRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public CategoryDTO update(CategoryDTO dto, Integer id) {
        Optional<CategoryEntity> optional=categoryRepository.findById(id);
        if (optional.isEmpty()){
            throw new CategoryNotFoundException("category not found");
        }
        CategoryEntity entity= optional.get();
        entity.setName(dto.getName());
        categoryRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }


    public Boolean delete(Integer id) {
        Optional<CategoryEntity> optional=categoryRepository.findById(id);
        if (optional.isEmpty()){
            throw new CategoryNotFoundException("category not found");
        }
        categoryRepository.delete(optional.get());
        return true;
    }
}
