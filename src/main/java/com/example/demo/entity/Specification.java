package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "specifications")
public class Specification {
    @Id
    @Column(name = "specificationID", nullable = false, length = 100)
    private String specificationID;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "specificationID", nullable = false)
    private Product products;

    @ColumnDefault("'Dài 192cm x Rộng 132cm x Cao 72cm'")
    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "material")
    private String material;

    @Column(name = "original", length = 100)
    private String original;

    @Column(name = "standard")
    private String standard;

    @Column(name = "productID", length = 100)
    private String productID;

}