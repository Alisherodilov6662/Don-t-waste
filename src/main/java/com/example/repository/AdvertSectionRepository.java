package com.example.repository;

import com.example.entity.advert.AdvertSectionEntity;
import com.example.entity.advert.AdvertsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author: Alisher Odilov
 * Date: 11.07.2023
 */
@Repository
public interface AdvertSectionRepository extends JpaRepository<AdvertSectionEntity, Integer> {

    Optional<AdvertSectionEntity> findByName(String name);
}
