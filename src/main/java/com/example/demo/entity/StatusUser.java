package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "status_user")
public class StatusUser {
    @Id
    @Column(name = "statusID", nullable = false)
    private Integer id;

    @Column(name = "Description", length = 500)
    private String description;

}