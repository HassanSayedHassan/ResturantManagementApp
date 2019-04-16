package com.example.cateringplatform.apiclient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit;
    public static final String BASE_URL = "http://3.17.241.18/thoag_sandbox/api/v5";

    public static Retrofit getRetrofit(){

        if (retrofit==null){

            retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }

        return retrofit;
    }
}
