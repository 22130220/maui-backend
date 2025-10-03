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
@Table(name = "order_status")
public class OrderStatus {
    @Id
    @Column(name = "orderStatusID", nullable = false)
    private Integer id;

    @Column(name = "orderStatusName", nullable = false, length = 50)
    private String orderStatusName;

}