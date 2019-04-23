package com.example.cateringplatform.activity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.cateringplatform.BASE_URL_IMAGE
import com.example.cateringplatform.R
import com.example.cateringplatform.adapters.FeaturedFoodCategoryAdapter
import com.example.cateringplatform.adapters.FeaturedResturantAdapter
import com.example.cateringplatform.adapters.OpenedFoodCategoryAdapter
import com.example.cateringplatform.models.FeaturedRestaurant
import com.example.cateringplatform.models.OpenRestaurant
import kotlinx.android.synthetic.main.activity_details_resturant.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var objFeaturedResturant: FeaturedRestaurant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_resturant)

        rv_type.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        rv_type.setHasFixedSize(true)

        rv_details.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_details.setHasFixedSize(true)

        tv_view_info.setOnClickListener(View.OnClickListener {

            intent = Intent(applicationContext, ViewInfoActivity::class.java)
            intent.putExtra("Name", objFeaturedResturant.restaurant_name)
            intent.putExtra("Status", objFeaturedResturant.status)
            intent.putExtra("StartTime", objFeaturedResturant.delivery_start_time)
            intent.putExtra("EndTime", objFeaturedResturant.delivery_end_time)
            intent.putExtra("MinimumOrder", objFeaturedResturant.minimum_order_price)
            intent.putExtra("DeliveryCharge", objFeaturedResturant.delivery_charge)
            intent.putExtra("CardDelivery", objFeaturedResturant.accept_card)
            intent.putExtra("CashDelivery", objFeaturedResturant.accept_cash_delivery)
            intent.putExtra("Cuisines", objFeaturedResturant.restaurant_cuisines)
            startActivity(intent)
        })

        iv_back_details.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

        setValue()
    }

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
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        iv_details_res_logo.setImageResource(R.drawable.app_icon)
                        return true
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        return false
                    }
                })
                .into(iv_details_res_logo)

        var minOrderNotice: Double = objFeaturedResturant.minimum_order_notice.toDouble()

        var minOrderDays: Int = minOrderNotice.toInt() / 24

        var minOrderHours: Int = minOrderNotice.toInt() % 24

        validateOrderNotice(minOrderDays, minOrderHours)

        val featuredFoodCategoryAdapter = FeaturedFoodCategoryAdapter(applicationContext, objFeaturedResturant.food_category)
        rv_type.adapter = featuredFoodCategoryAdapter

        val openedFoodCategoryAdapter = OpenedFoodCategoryAdapter(applicationContext, objFeaturedResturant.food_category)
        rv_details.adapter = openedFoodCategoryAdapter
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