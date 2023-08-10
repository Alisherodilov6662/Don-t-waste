package com.example.entity.advert;

import com.example.entity.AttachEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Author: Alisher Odilov
 * Date: 21.06.2023
 */

@Entity
@Table(name = "advert_category_entity")
public class AdvertCategoryEntity {
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
