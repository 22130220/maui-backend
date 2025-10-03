package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userID", nullable = false)
    private User userID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roleID", nullable = false)
    private Role roleID;

}