package com.example.cateringplatform.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.cateringplatform.BASE_URL_IMAGE
import com.example.cateringplatform.R
import com.example.cateringplatform.adapters.FeaturedFoodCategoryAdapter
import com.example.cateringplatform.adapters.OpenedFoodCategoryAdapter
import com.example.cateringplatform.models.FeaturedRestaurant
import kotlinx.android.synthetic.main.activity_details_resturant.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var objFeaturedResturant: FeaturedRestaurant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_resturant)

        rv_type.layoutManager= LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        rv_type.setHasFixedSize(true)

        rv_details.layoutManager= LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        rv_details.setHasFixedSize(true)

        setValue()
    }

//    private fun setValueforOpen() {
//        objOpenResturant = intent.getSerializableExtra("OpenResturant") as OpenRestaurant
//
//        tv_res_name_details.text = objOpenResturant.restaurant_name
//
//        if (objOpenResturant.accept_cash_delivery == 1 && objOpenResturant.accept_card == 1) {
//            tv_payment_option.text = "Bank transfer, Card"
//        } else if (objOpenResturant.accept_cash_delivery == 1 && objOpenResturant.accept_card == 0) {
//            tv_payment_option.text = "Bank transfer"
//        } else if (objOpenResturant.accept_cash_delivery == 0 && objOpenResturant.accept_card == 1) {
//            tv_payment_option.text = "Card"
//        } else {
//            tv_payment_option.visibility = View.GONE
//        }
//
//
//        tv_res_min_order_price.text = "Min: " + objOpenResturant.minimum_order_price + " SAR"
//        tv_delivery_charge.text = "Delivery: " + objOpenResturant.delivery_charge + " SAR"
//
//        var imageUrl2: String = BASE_URL_IMAGE + "/" + objOpenResturant.restaurant_url + "/images/" + objOpenResturant.restaurant_logo
//
//        Glide.with(applicationContext)
//                .load(imageUrl2)
//                .into(iv_details_res_logo)
//
//        var minOrderNoticeOpenRes: Double = objOpenResturant.minimum_order_notice.toDouble()
//
//        var minOrderDaysOpenRes: Int = minOrderNoticeOpenRes.toInt() / 24
//
//        var minOrderHoursOpenRes: Int = minOrderNoticeOpenRes.toInt() % 24
//
//        validateOrderNotice(minOrderDaysOpenRes, minOrderHoursOpenRes)
//    }

    private fun setValue() {
        objFeaturedResturant = intent.getSerializableExtra("Featured") as FeaturedRestaurant

        tv_res_name_details.text = objFeaturedResturant.restaurant_name

        if (objFeaturedResturant.accept_cash_delivery == 1 && objFeaturedResturant.accept_card == 1) {
            tv_payment_option.text = "Bank transfer, Card"
        } else if (objFeaturedResturant.accept_cash_delivery == 1 && objFeaturedResturant.accept_card == 0) {
            tv_payment_option.text = "Bank transfer"
        } else if (objFeaturedResturant.accept_cash_delivery == 0 && objFeaturedResturant.accept_card == 1) {
            tv_payment_option.text = "Card"
        } else {
            tv_payment_option.visibility = View.GONE
        }

        tv_res_min_order_price.text = "Min: " + objFeaturedResturant.minimum_order_price + " SAR"
        tv_delivery_charge.text = "Delivery: " + objFeaturedResturant.delivery_charge + " SAR"

        var imageUrl: String = BASE_URL_IMAGE + "/" + objFeaturedResturant.restaurant_url + "/images/" + objFeaturedResturant.restaurant_logo

        Glide.with(applicationContext)
                .load(imageUrl)
                .into(iv_details_res_logo)

        var minOrderNotice: Double = objFeaturedResturant.minimum_order_notice.toDouble()

        var minOrderDays: Int = minOrderNotice.toInt() / 24

        var minOrderHours: Int = minOrderNotice.toInt() % 24

        validateOrderNotice(minOrderDays, minOrderHours)

        val featuredFoodCategoryAdapter = FeaturedFoodCategoryAdapter(applicationContext,objFeaturedResturant.food_category)
        rv_type.adapter=featuredFoodCategoryAdapter

        val openedFoodCategoryAdapter= OpenedFoodCategoryAdapter(applicationContext,objFeaturedResturant.food_category)
        rv_details.adapter=openedFoodCategoryAdapter
    }

    private fun validateOrderNotice(minOrderDays: Int, minOrderHours: Int) {
        if (minOrderDays == 0) {
            if (minOrderHours == 1) {
                tv_min_order.text = "Minimum time to order: " + minOrderHours + " hour"
            } else {
                tv_min_order.text = "Minimum time to order: " + minOrderHours + " hours"
            }
        } else if (minOrderHours == 0) {
            if (minOrderDays == 1) {
                tv_min_order.text = "Minimum time to order: " + minOrderDays + " day"
            } else {
                tv_min_order.text = "Minimum time to order: " + minOrderDays + " days"
            }
        } else {
            if (minOrderDays == 1 && minOrderHours == 1) {
                tv_min_order.text = "Minimum time to order: " + minOrderDays + " day " + minOrderHours + " hour"
            } else {
                tv_min_order.text = "Minimum time to order: " + minOrderDays + " days " + minOrderHours + " hours"
            }
        }
    }
}