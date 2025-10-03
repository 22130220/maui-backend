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
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "roleID", nullable = false)
    private Integer id;

    @Column(name = "roleName", nullable = false, length = 100)
    private String roleName;

}