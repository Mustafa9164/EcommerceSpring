package com.tcs.app.service;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.entity.Category;
import com.tcs.app.entity.Product;
import com.tcs.app.exception.ProductNotFoundException;
import com.tcs.app.mapper.ProductMapper;
import com.tcs.app.repository.CategoryRepository;
import com.tcs.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ProductService implements IProductService{

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    @Autowired
    ProductService(ProductRepository repo,CategoryRepository categoryRepository){
        this.repo=repo;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public ProductDto getProductById(Long id) throws Exception {
        /*return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product Not found"));*/
        Product product = repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
        ProductDto dto=ProductMapper.toDto(product);
        return  dto;
    }

    @Override
    public ProductDto createProduct(ProductDto dto) throws Exception {

        Category category=categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Catgory not found"));
        Product saved = repo.save(ProductMapper.toEntity(dto,category)); //covert dto to entity
        return  ProductMapper.toDto(saved);                     //dto to entity
    }
}
