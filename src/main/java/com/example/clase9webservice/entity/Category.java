package com.example.clase9webservice.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID", nullable = false)
    private Integer id;

    @Column(name = "CategoryName", nullable = false, length = 15)
    private String categoryName;

    @Lob
    @Column(name = "Description")
    private String description;

    @Column(name = "Picture")
    private byte[] picture;

}