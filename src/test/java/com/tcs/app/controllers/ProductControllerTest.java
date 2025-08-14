package com.tcs.app.controllers;

import com.tcs.app.entity.Category;
import com.tcs.app.entity.Product;
import com.tcs.app.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {//(tabnine

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;


    @Test
    void getProductById_shouldreturnByProductById() throws Exception {
        Product product=Product.builder().brand("samsung").
                discount(234).price(870).image("he.jpg")
                .category(Category.builder().build())
                .build();
        product.setId(1l);
/*
        when(productService.getProductById(1l)).thenReturn(Optional.of(product));
*/
/*
        when(productService.getProductById(1L)).thenReturn(product);
*/

        
    }

    @Test
    void createProduct() {

    }
}