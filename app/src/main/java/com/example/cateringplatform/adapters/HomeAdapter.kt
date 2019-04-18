package com.example.cateringplatform.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.cateringplatform.R
import com.example.cateringplatform.Utills.hideProgressBar
import com.example.cateringplatform.Utills.showToast
import com.example.cateringplatform.models.FindResturantModel
import com.example.cateringplatform.models.GetCuisineModel
import com.example.cateringplatform.webservice.WebService

class HomeAdapter(val context: Context?, val findResturantModel: FindResturantModel?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {

        if (i == VIEW_TYPE_FOOD_TYPE) {
            val foodType = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_food_type, viewGroup, false)
            return FoodTypeHolder(foodType)
        } else if (i == VIEW_TYPE_FEATURE_RESTURANT) {
            val featureResturant = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_feature_resturant, viewGroup, false)
            return FeatureResturantHolder(featureResturant)
        } else {
            val availableResturant = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_available_resturant, viewGroup, false)
            return AvailableResturantHolder(availableResturant)
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {

        val itemType = getItemViewType(i)

        if (itemType == VIEW_TYPE_FOOD_TYPE) {
            val foodTypeHolder = viewHolder as FoodTypeHolder
            foodTypeHolder.foodTypeRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


            WebService.CallGetCuisineAPI { responseObj, error ->

                if (error == null) {

                    hideProgressBar()

                    val getCuisineModel: GetCuisineModel? = responseObj

                    val foodTypeAdapter = FoodTypeAdapter(context, getCuisineModel)
                    foodTypeHolder.foodTypeRecycler.adapter = foodTypeAdapter

                    Log.d("onResponseCuisine", "" + responseObj)
                    Log.i("1555",""+getCuisineModel?.response?.cuisine_list?.get(i)?.cuisine_name)

                } else {
                    hideProgressBar()
                    showToast(context!!, "" + error)
                    Log.d("onErrorCuisine", "" + responseObj)

                }
            }
        } else if (itemType == VIEW_TYPE_FEATURE_RESTURANT) {

            val featureResturantHolder = viewHolder as FeatureResturantHolder
            val featuredResturantAdapter = FeaturedResturantAdapter(context, findResturantModel)
            featureResturantHolder.featureResturantRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            featureResturantHolder.featureResturantRecycler.adapter = featuredResturantAdapter
            Log.d("1111", "" + findResturantModel?.response?.featured_restaurant?.get(i)?.restaurant_name)
        } else {

            val availableResturantHolder = viewHolder as AvailableResturantHolder
            val availableResturantAdapter = AvailableResturantAdapter(context, findResturantModel)
            availableResturantHolder.availableResturantRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            availableResturantHolder.availableResturantRecycler.adapter = availableResturantAdapter
        }

    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_FOOD_TYPE
        } else if (position == 1) {
            VIEW_TYPE_FEATURE_RESTURANT
        } else {
            VIEW_TYPE_AVAILABLE_RESTURANT
        }
    }


    inner class FoodTypeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodTypeRecycler: RecyclerView

        init {
            foodTypeRecycler = itemView.findViewById(R.id.rv_food_type)
        }
    }

    inner class FeatureResturantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val featureTextView: TextView
        val featureResturantRecycler: RecyclerView

        init {
            featureResturantRecycler = itemView.findViewById(R.id.rv_featured_resturant)
            featureTextView = itemView.findViewById(R.id.tv_featured)
        }
    }

    inner class AvailableResturantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val availableTV: TextView
        val availableResturantRecycler: RecyclerView

        init {
            availableTV = itemView.findViewById(R.id.tv_available_on_date)
            availableResturantRecycler = itemView.findViewById(R.id.rv_available_resturant)
        }
    }

    companion object {

        val VIEW_TYPE_FOOD_TYPE = 0
        val VIEW_TYPE_FEATURE_RESTURANT = 1
        val VIEW_TYPE_AVAILABLE_RESTURANT = 2
    }
}
