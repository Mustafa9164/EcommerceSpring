package com.tcs.app.service;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.entity.Product;
import com.tcs.app.mapper.ProductMapper;
import com.tcs.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ProductService implements IProductService{

    private final ProductRepository repo;

    @Autowired
    ProductService(ProductRepository repo){
        this.repo=repo;
    }
    @Override
    public ProductDto getProductById(Long id) throws Exception {
        /*return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product Not found"));*/
        Product product = repo.findById(id).orElseThrow(() -> new Exception("Product Not Found"));
        ProductDto dto=ProductMapper.toDto(product);
        return  dto;
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        Product saved = repo.save(ProductMapper.toEntity(dto)); //covert dto to entity
        return  ProductMapper.toDto(saved);                     //dto to entity
    }
}
