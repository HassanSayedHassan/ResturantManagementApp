package com.example.cateringplatform.adapters

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cateringplatform.R
import com.example.cateringplatform.activity.DetailsActivity
import com.example.cateringplatform.models.FoodCategory
import com.example.cateringplatform.models.OpenRestaurant
import kotlinx.android.synthetic.main.item_featured_food_category.view.*

class FeaturedFoodCategoryAdapter(val context: Context,val foodCategoryList: List<FoodCategory>): RecyclerView.Adapter<FeaturedFoodCategoryAdapter.FeaturedFoodCatHolder>() {

    private var rowIndex:Int = -1

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FeaturedFoodCatHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_featured_food_category,p0,false)
        return FeaturedFoodCatHolder(view)
    }

    override fun getItemCount(): Int {

        return foodCategoryList.size

    }

    override fun onBindViewHolder(p0: FeaturedFoodCatHolder, p1: Int) {

        p0.itemView.tv_food_category.text = foodCategoryList.get(p1).category_name
        println(foodCategoryList[p1].category_name)

        p0.itemView.setOnClickListener(View.OnClickListener {

            rowIndex = p1
            notifyDataSetChanged()
        })

        if (rowIndex==p1){
            p0.itemView.tv_food_category.setBackgroundResource(R.drawable.round_back_red)
            p0.itemView.tv_food_category.setTextColor(Color.parseColor("#FFFFFF"))
        } else {
            p0.itemView.tv_food_category.setBackgroundResource(R.color.colorOffWhite)
            p0.itemView.tv_food_category.setTextColor(Color.parseColor("#000000"))
        }

    }

    class FeaturedFoodCatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val foodCategoryTV:TextView

        init {
            foodCategoryTV=itemView.findViewById(R.id.tv_food_category)
        }
    }
}