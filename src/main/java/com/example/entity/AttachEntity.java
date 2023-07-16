package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
@Getter
@Setter
@Entity
@Table(name = "attach")
public class AttachEntity {

    @Id
    @GenericGenerator(name = "attach_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column
    private String originalName;

    @Column
    private Long size;
    
    @Column
    private String type;

    @Column
    private String path;

}
