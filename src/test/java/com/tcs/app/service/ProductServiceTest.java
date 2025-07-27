package com.tcs.app.service;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.entity.Category;
import com.tcs.app.entity.Product;
import com.tcs.app.mapper.ProductMapper;
import com.tcs.app.repository.CategoryRepository;
import com.tcs.app.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository; // ✅ REQUIRED


    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("Should return product")
    void getProductById_shouldReturnProduct() throws Exception {

        Product product=Product.builder().brand("samsung").
                discount(234).price(870).image("he.jpg")
                .category(Category.builder().build())
                .build();
        product.setId(1l);

        when(productRepository.findById(1l)).thenReturn(Optional.of(product));

        ProductDto result = productService.getProductById(1l);

        assertEquals(result.getBrand(),"samsung");
        verify(productRepository, times(1)).findById(1l);
    }

    @Test
    @DisplayName("Should create a product and return the saved product DTO")
    void createProduct() throws Exception {
        Category category=new Category();
        Product product=Product.builder().brand("samsung").
                discount(234).price(870).image("he.jpg")
                .category(category)
                .build();
        product.setId(1l);

        ProductDto dto=new ProductDto();
        dto.setCategoryId(1l);

        when(categoryRepository.findById(1l)).thenReturn(Optional.of(category));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDto result = productService.createProduct(dto);

/*
        assertEquals(result.getImage(),"he.jpg");
*/
        assertEquals(result.getBrand(),"samsung");
        verify(productRepository,times(1)).save(any(Product.class));
    }
}