package com.example.repository;

import com.example.entity.advert.AdvertsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Alisher Odilov
 * Date: 03.04.2023
 */
@Repository
public interface AdvertRepository extends JpaRepository<AdvertsEntity,Long> {
}
