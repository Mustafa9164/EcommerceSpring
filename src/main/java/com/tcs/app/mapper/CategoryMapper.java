package com.tcs.app.mapper;

import com.tcs.app.dto.CategoryDTO;
import com.tcs.app.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO){
        return  Category.builder()

                .name(categoryDTO.getName())
                .build();
    }

}
