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
@Table(name = "vouchertype")
public class Vouchertype {
    @Id
    @Column(name = "typeID", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

}