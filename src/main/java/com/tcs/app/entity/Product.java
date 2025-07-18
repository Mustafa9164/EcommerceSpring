package com.tcs.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product extends BaseEntity {

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    //private Long id;
    private String title;
   // private String category;
    private String brand;
    private boolean popular;

    @ManyToOne()
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;
}