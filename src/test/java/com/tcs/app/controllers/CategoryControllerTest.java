package com.tcs.app.controllers;

import com.tcs.app.dto.CategoryDTO;
import com.tcs.app.service.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MediaType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/categories should return all categories")
    void getAllCategory() throws Exception {

        List<CategoryDTO> list  = new ArrayList<>();
        CategoryDTO cat1 = CategoryDTO.builder().name("Electronics").id(1l).build();
        CategoryDTO cat2 = CategoryDTO.builder().name("Books").id(2l).build();
        CategoryDTO cat3 = CategoryDTO.builder().name("cloth").id(3l).build();
        list.add(cat1);
        list.add(cat2);
        list.add(cat3);

        when(categoryService.getAllCatgories()).thenReturn(list);

        //mockMvc.perform(get("/api/categories").contentType(MediaType.APPLICATION_JSON));
        mockMvc.perform(get("/api/categories").contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath( "$[0].id").value(1))
                .andExpect(jsonPath( "$[0].name").value("Electronics"))
                .andExpect(jsonPath( "$[1].id").value(2))
                .andExpect(jsonPath( "$[1].name").value("Books"))
                .andExpect(jsonPath( "$[2].id").value(3))
                .andExpect(jsonPath( "$[2].name").value("Clothing"));

        // Assert
        verify(categoryService, times(1)).getAllCatgories();

    }

    @Test
    void createCategory() {
    }
}