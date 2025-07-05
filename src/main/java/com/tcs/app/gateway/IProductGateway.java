package com.tcs.app.gateway;

import com.tcs.app.dto.ProductDto;
import com.tcs.app.gateway.api.FakeStoreProductApi;

public interface IProductGateway {


    ProductDto getProductById(Long id) throws Exception;
}
