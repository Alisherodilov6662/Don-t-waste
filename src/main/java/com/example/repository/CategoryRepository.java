package com.example.repository;

import com.example.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Alisher Odilov
 * Date: 30.03.2023
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
