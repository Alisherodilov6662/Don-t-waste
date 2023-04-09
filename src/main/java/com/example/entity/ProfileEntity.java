package com.example.entity;

import com.example.enums.ProfileRole;
import com.example.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author: Alisher Odilov
 * Date: 17.03.2023
 */
@Data
@Entity
@Table(name = "profile_entity")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;
    @Column
    @Enumerated(value = EnumType.STRING)
    private ProfileRole role;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "attach_id")
    private String attach_id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_id", insertable = false, updatable = false)
    private AttachEntity attach;

}
