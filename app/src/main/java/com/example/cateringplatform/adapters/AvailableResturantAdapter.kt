package com.example.cateringplatform.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.cateringplatform.BASE_URL_IMAGE

import com.example.cateringplatform.R
import com.example.cateringplatform.Utills.hideProgressBar
import com.example.cateringplatform.Utills.showProgressBar
import com.example.cateringplatform.activity.DetailsActivity
import com.example.cateringplatform.models.FindResturantModel
import kotlinx.android.synthetic.main.item_available_resturant.view.*

class AvailableResturantAdapter(val context: Context?, val findResturantModel: FindResturantModel?) : RecyclerView.Adapter<AvailableResturantAdapter.AvailResHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AvailResHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_available_resturant, viewGroup, false)
        return AvailResHolder(view)
    }

    override fun onBindViewHolder(availResHolder: AvailResHolder, i: Int) {

        availResHolder.itemView.tv_available_resturant_name.text=findResturantModel?.response?.open_restaurant?.get(i)?.restaurant_name
        availResHolder.itemView.tv_available_min_price.text="Min: "+findResturantModel?.response?.open_restaurant?.get(i)?.minimum_order_price+" SAR"
        availResHolder.itemView.tv_available_delivery_price.text="Delivery: "+findResturantModel?.response?.open_restaurant?.get(i)?.delivery_charge+" SAR"


        var imageUrl: String = BASE_URL_IMAGE+"/"+findResturantModel?.response?.open_restaurant?.get(i)?.restaurant_url+"/images/"+findResturantModel?.response?.open_restaurant?.get(i)?.restaurant_logo

        Glide.with(context!!)
                .load(imageUrl)
                .into(availResHolder.itemView.iv_open_resturant_logo)


        if (findResturantModel?.response?.open_restaurant?.get(i)?.accept_cash_delivery==1){

            availResHolder.itemView.iv_bank_delivery.setImageResource(R.drawable.ic_cash_on_delivery)
            availResHolder.itemView.iv_bank_delivery.visibility = View.VISIBLE
        } else {
            availResHolder.itemView.iv_bank_delivery.visibility = View.GONE
        }

        if (findResturantModel?.response?.open_restaurant?.get(i)?.accept_card==1){

            availResHolder.itemView.iv_card_delivery.setImageResource(R.drawable.ic_card_payment)
            availResHolder.itemView.iv_card_delivery.visibility = (View.VISIBLE)
        } else {

            availResHolder.itemView.iv_card_delivery.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return findResturantModel?.response?.open_restaurant!!.size
    }

    inner class AvailResHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView
        private val availableMinPrice : TextView
        private val availableDeliveryPrice : TextView

        init {
            cardView = itemView.findViewById(R.id.cv_res_name)
            availableMinPrice = itemView.findViewById(R.id.tv_available_min_price)
            availableDeliveryPrice = itemView.findViewById(R.id.tv_available_delivery_price)
        }
    }
}
