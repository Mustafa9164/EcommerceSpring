package com.tcs.app.service;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.entity.Product;
import com.tcs.app.gateway.IProductGateway;
import org.springframework.stereotype.Service;

@Service
public class FakeStroreProductService implements  IProductService {

    private IProductGateway iProductGateway;

    FakeStroreProductService(IProductGateway iProductGateway){
        this.iProductGateway=iProductGateway;
    }
    @Override
    public ProductDto getProductById(Long id) throws Exception {
        return iProductGateway.getProductById(id);
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        return null;
    }
}
