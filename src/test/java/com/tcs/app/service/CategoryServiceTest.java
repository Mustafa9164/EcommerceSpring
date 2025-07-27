package com.tcs.app.service;

import com.tcs.app.dto.CategoryDTO;
import com.tcs.app.entity.Category;
import com.tcs.app.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_fetchALlCategories() throws IOException{

        //arrange
        List<Category> list = new ArrayList<>();
        /*Category category1=Category.builder()
                .name("Electronics")
                .build();*/

        Category category1=new Category();
        category1.setName("Electronics");
        Category category2=Category.builder()
                .name("Book")
                .build();


        list.add(category1);
        list.add(category2);

        when(categoryRepository.findAll()).thenReturn(list);

        //act
        List<CategoryDTO> result = categoryService.getAllCatgories();
        //assert
        assertEquals(result.size(),2);
        verify(categoryRepository,times(1)).findAll();
    }

    @Test
    @DisplayName("Should return empty list when no categories exist")
    void getAllCategories_shouldReturnEmptyListWhenNoCategoriesExist() throws IOException {


        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());

        List<CategoryDTO> result = categoryService.getAllCatgories();
        assertEquals(result.size(),0);
        verify(categoryRepository,times(1)).findAll();
    }
    @Test
    @DisplayName(("create categories"))
    void createCategory_shouldreturnCategoryByName() throws Exception {

        Category category=new Category();
        category.setName("Electronics");
        CategoryDTO categoryDTO=new CategoryDTO();

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryDTO result = categoryService.createCategory(categoryDTO);

        assertEquals(result.getName(),"Electronics");
        verify(categoryRepository,times(1)).save(any(Category.class));
    }

}
