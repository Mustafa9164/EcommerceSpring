package com.tcs.app.controllers;

import com.tcs.app.dto.CategoryDTO;
import com.tcs.app.entity.Category;
import com.tcs.app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private final ICategoryService categoryService;

    CategoryController(ICategoryService _categoryService){
        this.categoryService=_categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory() throws IOException {
        List<CategoryDTO> allCatgories =this.categoryService.getAllCatgories();
        return  ResponseEntity.ok(allCatgories);
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws Exception {
        CategoryDTO created = this.categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(created);
    }

}
