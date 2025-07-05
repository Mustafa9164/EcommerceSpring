package com.tcs.app.gateway;

import com.tcs.app.dto.FakeStoreCategoryResponseDto;
import com.tcs.app.dto.FakeStoreProductResponseDto;
import com.tcs.app.dto.ProductDto;
import com.tcs.app.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class FakeStoreProductGateway implements  IProductGateway{

    private final FakeStoreProductApi fakeStoreProductApi;

    FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi){
        this.fakeStoreProductApi=fakeStoreProductApi;
    }
    @Override
    public ProductDto getProductById(Long id) throws Exception {
        FakeStoreProductResponseDto response = this.fakeStoreProductApi.getFakeProduct(id).execute().body();
        if(response== null){
            throw  new IOException();
        }
        return response.getProduct();
    }
}
