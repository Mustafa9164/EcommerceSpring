package com.tcs.app.service;

import com.tcs.app.dto.CategoryDTO;
import com.tcs.app.entity.Category;
import com.tcs.app.entity.Product;
import com.tcs.app.mapper.CategoryMapper;
import com.tcs.app.mapper.ProductMapper;
import com.tcs.app.repository.CategoryRepository;
import com.tcs.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CategoryService implements ICategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<CategoryDTO> getAllCatgories() throws IOException {
        List<CategoryDTO> dtos = new ArrayList<>();
        List<Category> all = categoryRepository.findAll();
        for(Category category: all){
            CategoryDTO categoryDTO = CategoryMapper.toDto(category);
            dtos.add(categoryDTO);
        }
        return dtos;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDto) throws Exception {
        Category category = CategoryMapper.toEntity(categoryDto);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDto(saved);
    }
}
