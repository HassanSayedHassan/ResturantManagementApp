package com.example.cateringplatform.APIConfig

import com.example.cateringplatform.API.APIServices
import com.example.cateringplatform.API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var apiServices = APIConfig().apiServices

class APIConfig{

    var retrofit:Retrofit = Retrofit.Builder().
            addConverterFactory(GsonConverterFactory.create()).
            baseUrl(API_BASE_URL).
            build()

    var apiServices:APIServices = retrofit.create(APIServices::class.java)
}