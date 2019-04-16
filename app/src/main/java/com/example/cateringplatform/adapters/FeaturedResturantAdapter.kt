package com.example.cateringplatform.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.cateringplatform.R

class FeaturedResturantAdapter : RecyclerView.Adapter<FeaturedResturantAdapter.FeaturedHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): FeaturedHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_featured_resturant, viewGroup, false)
        return FeaturedHolder(view)
    }

    override fun onBindViewHolder(featuredHolder: FeaturedHolder, i: Int) {

    }

    override fun getItemCount(): Int {
        return 5
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
