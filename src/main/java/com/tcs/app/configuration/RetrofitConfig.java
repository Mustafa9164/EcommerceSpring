package com.tcs.app.configuration;

import com.tcs.app.gateway.api.FakeStoreCategoryApi;
import com.tcs.app.gateway.api.FakeStoreProductApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder().baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit){
        return  retrofit.create(FakeStoreProductApi.class);
    }

}
