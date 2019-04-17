package com.example.cateringplatform.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.cateringplatform.BASE_URL_IMAGE

import com.example.cateringplatform.R
import com.example.cateringplatform.models.FindResturantModel
import kotlinx.android.synthetic.main.item_featured_resturant.view.*

class FeaturedResturantAdapter(val context: Context?, val findResturantModel: FindResturantModel?) : RecyclerView.Adapter<FeaturedResturantAdapter.FeaturedHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): FeaturedHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_featured_resturant, viewGroup, false)
        return FeaturedHolder(view)
    }

    override fun onBindViewHolder(featuredHolder: FeaturedHolder, i: Int) {

        featuredHolder.itemView.tv_feat_resturant.text = findResturantModel?.response?.featured_restaurant?.get(i)?.restaurant_name

        var imageUrl: String = BASE_URL_IMAGE +"/"+findResturantModel?.response?.featured_restaurant?.get(i)?.restaurant_url+"/images/"+findResturantModel?.response?.featured_restaurant?.get(i)?.restaurant_logo


        Glide.with(context!!)
                .load(imageUrl)
                .into(featuredHolder.itemView.iv_feat_food)

        Log.d("11112",""+findResturantModel?.response?.featured_restaurant?.get(i)?.restaurant_name)

    }

    override fun getItemCount(): Int {
        return findResturantModel?.response?.featured_restaurant!!.size
    }

    inner class FeaturedHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val featuredResIcon: ImageView
        private val featuredResTV: TextView

        init {
            featuredResIcon = itemView.findViewById(R.id.iv_feat_food)
            featuredResTV = itemView.findViewById(R.id.tv_feat_resturant)
        }
    }
}
