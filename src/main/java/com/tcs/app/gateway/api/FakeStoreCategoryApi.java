package com.tcs.app.gateway.api;

import com.tcs.app.dto.FakeStoreCategoryResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

public interface FakeStoreCategoryApi {
    @GET("products/category")
    Call<FakeStoreCategoryResponseDto> getAllFakeCategories() throws IOException;
}
