package com.example.entity;

import jakarta.persistence.*;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
@Entity
@Table(name = "attach")
public class AttachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

}
