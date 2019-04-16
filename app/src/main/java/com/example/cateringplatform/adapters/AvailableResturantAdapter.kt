package com.example.cateringplatform.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cateringplatform.R

class AvailableResturantAdapter : RecyclerView.Adapter<AvailableResturantAdapter.AvailResHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AvailResHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_available_resturant, viewGroup, false)
        return AvailResHolder(view)
    }

    override fun onBindViewHolder(availResHolder: AvailResHolder, i: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class AvailResHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView

        init {
            cardView = itemView.findViewById(R.id.cv_res_name)
        }
    }
}
