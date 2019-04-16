package com.example.cateringplatform.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.cateringplatform.R

class FoodTypeAdapter : RecyclerView.Adapter<FoodTypeAdapter.TypeHolderFood>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TypeHolderFood {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_food_type, viewGroup, false)
        return TypeHolderFood(view)
    }

    override fun onBindViewHolder(typeHolderFood: TypeHolderFood, i: Int) {

        typeHolderFood.itemView.setOnClickListener {
            typeHolderFood.foodTypeTV.setBackgroundResource(R.drawable.round_back_red)
            typeHolderFood.foodTypeTV.setTextColor(Color.parseColor("#FFFFFF"))
        }
    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class TypeHolderFood(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val foodTypeTV: TextView

        init {

            foodTypeTV = itemView.findViewById(R.id.tv_food_type)
        }
    }
}
