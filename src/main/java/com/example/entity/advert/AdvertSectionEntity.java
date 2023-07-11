package com.example.entity.advert;

import com.example.entity.AttachEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author: Alisher Odilov
 * Date: 18.06.2023
 */
@Data
@Entity
@Table(name = "advert_section_entity")
public class AdvertSectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "photo_id")
    private String photoId;

    @OneToOne
    @JoinColumn(name = "photo_id", insertable = false, updatable = false)
    private AttachEntity photo;

    @Column(name = "visible")
    private Boolean visible;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

}
