package com.example.cateringplatform.api;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("find-restaurant")
    Call<String> findResturantAPI();
}
