package com.tcs.app.mapper;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.entity.Category;
import com.tcs.app.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product){
        return ProductDto.builder()
                .color(product.getColor())
                .image(product.getImage())

                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                //.popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDto dto, Category category){
        return  Product.builder()
                .image(dto.getImage())
                .brand(dto.getBrand())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .model(dto.getModel())
                .title(dto.getTitle())
                .category(category)
                .discount(dto.getDiscount())
                .build();
    }
}
