package com.example.repository;

import com.example.entity.advert.AdvertCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023 7:42
 */
@Repository
public interface AdvertCategoryRepository extends JpaRepository<AdvertCategoryEntity, Integer> {
    Optional<AdvertCategoryEntity> findByName(String name);
}
