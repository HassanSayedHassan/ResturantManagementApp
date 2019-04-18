package com.example.cateringplatform.webservice

import android.util.Log
import com.example.cateringplatform.APIConfig.apiServices
import com.example.cateringplatform.models.FindResturantModel
import com.example.cateringplatform.models.GetCuisineModel
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object WebService {

    const val ON_FAILURE_MESSAGE = "Please check your internet connection"

    fun callFindResturantAPI(callback: (FindResturantModel?,String?)->Unit){

        apiServices.findResturantAPI().enqueue(object : Callback<FindResturantModel>{
            override fun onFailure(call: Call<FindResturantModel>, t: Throwable) {
                Log.d("findResturantResponse",""+t.localizedMessage);
                callback(null, ON_FAILURE_MESSAGE);
            }

            override fun onResponse(call: Call<FindResturantModel>, response: Response<FindResturantModel>) {
                Log.d("findResturantResponse",Gson().toJson(response.body()))
                Log.d("findResturantResponse",response.code().toString())


                if (response.isSuccessful){
                    callback(response.body(), null)
                } else{
                    callback(null, ON_FAILURE_MESSAGE)
                }
            }
        })


    }

    fun CallGetCuisineAPI(getCuisineCallback: (GetCuisineModel?,String?)->Unit){

        apiServices.getCuisinesAPI().enqueue(object : Callback<GetCuisineModel>{
            override fun onFailure(call: Call<GetCuisineModel>, t: Throwable) {
                Log.d("getCuisineResponse",""+t.localizedMessage);
                getCuisineCallback(null, ON_FAILURE_MESSAGE);            }

            override fun onResponse(call: Call<GetCuisineModel>, response: Response<GetCuisineModel>) {
                Log.d("getCuisineResponse",Gson().toJson(response.body()))
                Log.d("getCuisineResponse",response.code().toString())


                if (response.isSuccessful){
                    getCuisineCallback(response.body(), null)
                } else{
                    getCuisineCallback(null, ON_FAILURE_MESSAGE)
                }            }
        })
    }
}