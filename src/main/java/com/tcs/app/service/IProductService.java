package com.tcs.app.service;

import com.tcs.app.dto.ProductDto;

public interface IProductService {

    ProductDto getProductById(Long id) throws Exception;
}
