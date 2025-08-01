package com.tcs.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {


    @Column(nullable = false,unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
