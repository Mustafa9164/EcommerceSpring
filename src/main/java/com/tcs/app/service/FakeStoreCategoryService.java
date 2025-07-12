package com.tcs.app.service;

import com.tcs.app.dto.CategoryDTO;
import com.tcs.app.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{

    private  ICategoryGateway categoryGateway;
    @Autowired
    FakeStoreCategoryService(ICategoryGateway categoryGateway){
        this.categoryGateway=categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCatgories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO category) {
        return null;
    }
}
