package com.example.cateringplatform.adapters

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.cateringplatform.R
import com.example.cateringplatform.models.GetCuisineModel
import kotlinx.android.synthetic.main.item_food_type.view.*

class FoodTypeAdapter(val context: Context?,val getCuisineModel: GetCuisineModel?) : RecyclerView.Adapter<FoodTypeAdapter.TypeHolderFood>() {

    private var row_index:Int=-1

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TypeHolderFood {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_food_type, viewGroup, false)
        return TypeHolderFood(view)
    }

    override fun onBindViewHolder(typeHolderFood: TypeHolderFood, i: Int) {

            typeHolderFood.itemView.tv_food_type.text=getCuisineModel?.response?.cuisine_list?.get(i)?.cuisine_name

        if (row_index==i){
            typeHolderFood.foodTypeTV.setBackgroundResource(R.drawable.round_back_red)
            typeHolderFood.foodTypeTV.setTextColor(Color.parseColor("#FFFFFF"))
        } else{
            typeHolderFood.foodTypeTV.setBackgroundResource(R.drawable.roun_back_default)
            typeHolderFood.foodTypeTV.setTextColor(Color.parseColor("#000000"))
        }

        typeHolderFood.itemView.setOnClickListener(View.OnClickListener {

            row_index = i
            notifyDataSetChanged()
    })
            Log.i("555",""+getCuisineModel?.response?.cuisine_list?.get(i)?.cuisine_name)
    }

    override fun getItemCount(): Int {
        return getCuisineModel?.response?.cuisine_list!!.size
    }

    inner class TypeHolderFood(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val foodTypeTV: TextView


        init {

            foodTypeTV = itemView.findViewById(R.id.tv_food_type)
        }
    }
}
