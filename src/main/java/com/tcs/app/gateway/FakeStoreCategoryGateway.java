package com.tcs.app.gateway;

import com.tcs.app.dto.CategoryDTO;
import com.tcs.app.dto.FakeStoreCategoryResponseDto;
import com.tcs.app.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryGateway implements  ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi){
        this.fakeStoreCategoryApi=fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        //make the hhtp reqyest to the fakestore api to fetch all categories
        FakeStoreCategoryResponseDto response= fakeStoreCategoryApi.getAllFakeCategories().execute().body();
        if(response== null){
            throw  new IOException();
        }
        return response.getCategories().stream().map(category->CategoryDTO.builder()
                .name(category)
                .build()).toList();
    }
}
