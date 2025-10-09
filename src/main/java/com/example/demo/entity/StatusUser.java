package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Table(name = "status_user")
public class StatusUser {
    @Id
    @Column(name = "statusID", nullable = false)
    private Integer id;

    @Column(name = "Description", length = 500)
    private String description;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StatusUser{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}