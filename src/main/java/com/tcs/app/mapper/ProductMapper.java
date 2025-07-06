package com.tcs.app.mapper;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product){
        return ProductDto.builder()
                .color(product.getColor())
                .image(product.getImage())
                .category(product.getCategory())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                //.popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDto dto){
        return  Product.builder()
                .image(dto.getImage())
                .brand(dto.getBrand())
                .color(dto.getColor())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .model(dto.getModel())
                .title(dto.getTitle())
                .discount(dto.getDiscount())
                .build();
    }
}
