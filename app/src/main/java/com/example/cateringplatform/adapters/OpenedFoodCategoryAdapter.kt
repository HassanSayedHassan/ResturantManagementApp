package com.example.cateringplatform.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cateringplatform.R
import com.example.cateringplatform.models.FoodCategory
import kotlinx.android.synthetic.main.layout_open_food_category.view.*

class OpenedFoodCategoryAdapter(val context: Context,val foodCategoryList: List<FoodCategory>): RecyclerView.Adapter<OpenedFoodCategoryAdapter.OpenFoodCatHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OpenFoodCatHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.layout_open_food_category,p0,false)
        return OpenFoodCatHolder(view)
    }

    override fun getItemCount(): Int {

        return foodCategoryList.size
    }

    override fun onBindViewHolder(p0: OpenFoodCatHolder, p1: Int) {

        p0.itemView.tv_type_of_food.text= foodCategoryList[p1].category_name
    }

    class OpenFoodCatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       private val foodTypeTextView:TextView = itemView.findViewById(R.id.tv_type_of_food)

    }
}