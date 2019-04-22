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
import com.example.cateringplatform.adapters.OpenedFoodCategoryAdapter
import com.example.cateringplatform.models.OpenRestaurant
import kotlinx.android.synthetic.main.activity_open_details.*

class DetailsOpenActivity : AppCompatActivity() {

    private lateinit var objOpenRestaurant: OpenRestaurant


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_details)

        rv_type_open.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        rv_type_open.setHasFixedSize(true)

        rv_details_open.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rv_details_open.setHasFixedSize(true)

        tv_view_info_open.setOnClickListener(View.OnClickListener {

            intent = Intent(applicationContext,ViewInfoActivity::class.java)
            intent.putExtra("Name",objOpenRestaurant.restaurant_name)
            intent.putExtra("Status",objOpenRestaurant.status)
            intent.putExtra("StartTime",objOpenRestaurant.delivery_start_time)
            intent.putExtra("EndTime",objOpenRestaurant.delivery_end_time)
            intent.putExtra("MinimumOrder",objOpenRestaurant.minimum_order_price)
            intent.putExtra("DeliveryCharge",objOpenRestaurant.delivery_charge)
            intent.putExtra("CardDelivery",objOpenRestaurant.accept_card)
            intent.putExtra("CashDelivery",objOpenRestaurant.accept_cash_delivery)

            startActivity(intent)
        })
        setValueforOpen()
    }

    private fun setValueforOpen() {
        objOpenRestaurant = intent.getSerializableExtra("OpenResturant") as OpenRestaurant

        tv_res_name_details_open.text = objOpenRestaurant.restaurant_name

        if (objOpenRestaurant.accept_cash_delivery == 1 && objOpenRestaurant.accept_card == 1) {
            tv_payment_option_open.text = "Bank transfer, Card"
        } else if (objOpenRestaurant.accept_cash_delivery == 1 && objOpenRestaurant.accept_card == 0) {
            tv_payment_option_open.text = "Bank transfer"
        } else if (objOpenRestaurant.accept_cash_delivery == 0 && objOpenRestaurant.accept_card == 1) {
            tv_payment_option_open.text = "Card"
        } else {
            tv_payment_option_open.visibility = View.GONE
        }


        tv_res_min_order_price_open.text = "Min: " + objOpenRestaurant.minimum_order_price + " SAR"
        tv_delivery_charge_open.text = "Delivery: " + objOpenRestaurant.delivery_charge + " SAR"

        var imageUrl2: String = BASE_URL_IMAGE + "/" + objOpenRestaurant.restaurant_url + "/images/" + objOpenRestaurant.restaurant_logo

        Glide.with(applicationContext)
                .load(imageUrl2)
                .listener(object: RequestListener<Drawable>{
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        iv_details_res_logo_open.setImageResource(R.drawable.ic_error_image)
                        return true
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        return false
                    }
                })
                .into(iv_details_res_logo_open)

        var minOrderNoticeOpenRes: Double = objOpenRestaurant.minimum_order_notice.toDouble()

        var minOrderDaysOpenRes: Int = minOrderNoticeOpenRes.toInt() / 24

        var minOrderHoursOpenRes: Int = minOrderNoticeOpenRes.toInt() % 24

        validateOrderNotice(minOrderDaysOpenRes, minOrderHoursOpenRes)
        val featuredFoodCategoryAdapter = FeaturedFoodCategoryAdapter(applicationContext, objOpenRestaurant.food_category)
        rv_type_open.adapter = featuredFoodCategoryAdapter

        val openedFoodCategoryAdapter = OpenedFoodCategoryAdapter(applicationContext, objOpenRestaurant.food_category)
        rv_details_open.adapter = openedFoodCategoryAdapter
    }

    private fun validateOrderNotice(minOrderDays: Int, minOrderHours: Int) {
        if (minOrderDays == 0) {
            if (minOrderHours == 1) {
                tv_min_order_open.text = "Minimum time to order: " + minOrderHours + " hour"
            } else {
                tv_min_order_open.text = "Minimum time to order: " + minOrderHours + " hours"
            }
        } else if (minOrderHours == 0) {
            if (minOrderDays == 1) {
                tv_min_order_open.text = "Minimum time to order: " + minOrderDays + " day"
            } else {
                tv_min_order_open.text = "Minimum time to order: " + minOrderDays + " days"
            }
        } else {
            if (minOrderDays == 1 && minOrderHours == 1) {
                tv_min_order_open.text = "Minimum time to order: " + minOrderDays + " day " + minOrderHours + " hour"
            } else {
                tv_min_order_open.text = "Minimum time to order: " + minOrderDays + " days " + minOrderHours + " hours"
            }
        }
    }
}