package com.tcs.app.gateway.api;

import com.tcs.app.dto.FakeStoreProductResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public  interface FakeStoreProductApi {

    @GET("products/{id}")
    Call<FakeStoreProductResponseDto> getFakeProduct(@Path("id") long id) throws IOException;
}
