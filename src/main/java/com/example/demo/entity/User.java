package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "userID", nullable = false)
    private Integer id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phoneNumber", length = 50)
    private String phoneNumber;

    @ColumnDefault("current_timestamp()")
    @Column(name = "createAt", nullable = false)
    private Instant createAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "statusID", nullable = false)
    private StatusUser statusID;

    @Column(name = "activateCode", length = 200)
    private String activateCode;

    @Column(name = "lockUntil")
    private Instant lockUntil;

    @ColumnDefault("'0'")
    @Column(name = "failPassword")
    private String failPassword;

    @ColumnDefault("0")
    @Column(name = "accountType")
    private Integer accountType;

    @ColumnDefault("0")
    @Column(name = "banned")
    private Integer banned;
}