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
@Table(name = "features")
public class Feature {
    @Id
    @Column(name = "featureID", nullable = false)
    private Integer id;

    @Column(name = "featureName", nullable = false, length = 100)
    private String featureName;

    @Column(name = "featureURL", length = 50)
    private String featureURL;

}