package com.example.cateringplatform.models

import java.io.Serializable

data class FindResturantModel(
    val meta: Meta,
    val response: Response
)

data class Meta(
    val status: Int
)

data class Response(
    val closed_restaurant: List<Any>,
    val featured_restaurant: List<FeaturedRestaurant>,
    val message: String,
    val news: Any,
    val open_restaurant: List<OpenRestaurant>
)

data class OpenRestaurant(
    val accept_card: Int,
    val accept_cash_delivery: Int,
    val accept_cash_on_delivery: Int,
    val accept_sadad: Int,
    val address: String,
    val average_rating: Int,
    val catering_max_service_time: Any,
    val catering_preparation_time: Any,
    val city_id: Int,
    val contact_email: String,
    val contact_number: String,
    val contact_person: String,
    val created_at: String,
    val cuisine_ids: String,
    val delivery_charge: Int,
    val delivery_end_time: String,
    val delivery_start_time: String,
    val district_id: Int,
    val down_payment: Int,
    val food_category: List<FoodCategory>,
    val free_delivery: Int,
    val id: Int,
    val is_featured: Int,
    val is_offer: Int,
    val is_open: Int,
    val is_pre_order: Int,
    val is_recommended: Int,
    val is_tax: Int,
    val is_vat: Int,
    val latitude: Any,
    val location_list: List<Location>,
    val longitude: Any,
    val minimum_catering_order_notice: Any,
    val minimum_food_orders: Int,
    val minimum_order_notice: String,
    val minimum_order_price: Int,
    val payment_method: String,
    val preparation_time: Int,
    val restaurant_arabic_name: String,
    val restaurant_cuisines: String,
    val restaurant_cuisines_arabic_name: String,
    val restaurant_logo: String,
    val restaurant_name: String,
    val restaurant_owner: String,
    val restaurant_review: List<Any>,
    val restaurant_type: Int,
    val restaurant_url: String,
    val serve_catering: Int,
    val service_charge_fixed: Int,
    val service_charge_percentage: Int,
    val status: Int,
    val tax: Int,
    val thoag_commission: Int,
    val total_ratings: Int,
    val updated_at: String,
    val user_id: Int,
    val vat: Int,
    val vat_registration_number: String,
    val zip_code: String
):Serializable

data class Location(
    val city_arabic_name: String,
    val city_id: Int,
    val city_name: String,
    val district_list: List<District>,
    val location_for: Int,
    val location_type: Int
):Serializable

data class District(
    val address: String,
    val city_id: Int,
    val district_arabic_name: String,
    val district_id: Int,
    val district_name: String
):Serializable

data class FoodCategory(
    val category_arabic_name: String,
    val category_name: String,
    val category_url: String,
    val created_at: String,
    val id: Int,
    val restaurant_id: Int,
    val status: Int,
    val total_order: Int,
    val updated_at: String
):Serializable

data class FeaturedRestaurant(
    val accept_card: Int,
    val accept_cash_delivery: Int,
    val accept_cash_on_delivery: Int,
    val accept_sadad: Int,
    val address: String,
    val average_rating: Int,
    val catering_max_service_time: Any,
    val catering_preparation_time: Any,
    val city_id: Int,
    val contact_email: String,
    val contact_number: String,
    val contact_person: String,
    val created_at: String,
    val cuisine_ids: String,
    val delivery_charge: Int,
    val delivery_end_time: String,
    val delivery_start_time: String,
    val district_id: Int,
    val down_payment: Int,
    val food_category: List<FoodCategory>,
    val free_delivery: Int,
    val id: Int,
    val is_featured: Int,
    val is_offer: Int,
    val is_open: Int,
    val is_pre_order: Int,
    val is_recommended: Int,
    val is_tax: Int,
    val is_vat: Any,
    val latitude: String,
    val location_list: List<Location>,
    val longitude: String,
    val minimum_catering_order_notice: Any,
    val minimum_food_orders: Int,
    val minimum_order_notice: String,
    val minimum_order_price: Int,
    val payment_method: String,
    val preparation_time: Int,
    val restaurant_arabic_name: String,
    val restaurant_cuisines: String,
    val restaurant_cuisines_arabic_name: String,
    val restaurant_logo: String,
    val restaurant_name: String,
    val restaurant_owner: String,
    val restaurant_review: List<RestaurantReview>,
    val restaurant_type: Int,
    val restaurant_url: String,
    val serve_catering: Int,
    val service_charge_fixed: Int,
    val service_charge_percentage: Int,
    val status: Int,
    val tax: Int,
    val thoag_commission: Int,
    val total_ratings: Int,
    val updated_at: String,
    val user_id: Int,
    val vat: Int,
    val vat_registration_number: String,
    val zip_code: String
):Serializable

data class RestaurantReview(
    val comment: Any,
    val contact_number: String,
    val created_at: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String,
    val order_id: Int,
    val restaurant_id: Int,
    val review_rate: Int,
    val status: Int,
    val updated_at: String,
    val user_id: Int
):Serializable