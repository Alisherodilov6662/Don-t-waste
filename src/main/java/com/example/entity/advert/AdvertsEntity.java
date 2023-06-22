package com.example.entity.advert;

import com.example.entity.AttachEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Author: Alisher Odilov
 * Date: 21.06.2023
 */
@Getter
@Setter
@Entity
@Table(name = "adverts_entity")
public class AdvertsEntity {

    @Id
    @GenericGenerator(name = "adverts_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column
    private String name;

    @Column(name = "photo_id")
    private List<String> id;

    @OneToMany
    @JoinColumn(name = "photo_id", insertable = false, updatable = false)
    private List<AttachEntity> photo;

    @Column
    private String description;

    @Column(name = "phone_of_user")
    private String phoneOfUser;

    @Column
    private Boolean visible;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
