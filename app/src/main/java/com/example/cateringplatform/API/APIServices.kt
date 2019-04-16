package com.example.cateringplatform.API

import com.example.cateringplatform.models.FindResturantModel
import retrofit2.Call
import retrofit2.http.POST

interface APIServices {

    @POST("find-restaurant")
    fun findResturantAPI() : Call<FindResturantModel>
}