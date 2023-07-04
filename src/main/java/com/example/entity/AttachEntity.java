package com.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
@Entity
@Table(name = "attach")
public class AttachEntity {

    @Id
    @GenericGenerator(name = "attach_uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

}
