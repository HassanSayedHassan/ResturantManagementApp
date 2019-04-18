package com.example.cateringplatform.API

import com.example.cateringplatform.models.FindResturantModel
import com.example.cateringplatform.models.GetCuisineModel
import retrofit2.Call
import retrofit2.http.POST

interface APIServices {

    @POST("find-restaurant")
    fun findResturantAPI() : Call<FindResturantModel>

    @POST("get-cuisines")
    fun getCuisinesAPI() : Call<GetCuisineModel>
}