package com.jaetech.user.entity;

import com.jaetech.common.BaseEntity;
import com.jaetech.user.entity.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 45)
    private String nick;

    @Column(nullable = false, length = 45)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 45)
    private UserRole role;

}
