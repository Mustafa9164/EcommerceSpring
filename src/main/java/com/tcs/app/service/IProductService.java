package com.tcs.app.service;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.entity.Product;

public interface IProductService {

    ProductDto getProductById(Long id) throws Exception;

    ProductDto createProduct(ProductDto dto) throws Exception;
}
