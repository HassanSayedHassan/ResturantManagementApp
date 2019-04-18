package com.example.cateringplatform.models

data class GetCuisineModel(
    val meta: MetaCuisine,
    val response: ResponseCuisine
)

data class MetaCuisine(
    val status: Int
)

data class ResponseCuisine(
    val cuisine_list: List<Cuisine>,
    val message: String
)

data class Cuisine(
    val created_at: String,
    val cuisine_arabic_name: String,
    val cuisine_icon: String,
    val cuisine_name: String,
    val cusine_url: String,
    val id: Int,
    val status: Int,
    val updated_at: Any
)