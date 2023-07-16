package com.example.repository;

import com.example.entity.AttachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Alisher Odilov
 * Date: 16.07.2023
 */
@Repository
public interface AttachmentRepository extends JpaRepository<AttachEntity, String> {
}
