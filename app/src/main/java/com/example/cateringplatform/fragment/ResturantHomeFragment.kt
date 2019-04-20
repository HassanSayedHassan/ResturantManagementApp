package com.example.cateringplatform.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cateringplatform.R
import com.example.cateringplatform.Utills.hideProgressBar
import com.example.cateringplatform.Utills.showProgressBar
import com.example.cateringplatform.Utills.showToast
import com.example.cateringplatform.adapters.HomeAdapter
import com.example.cateringplatform.models.FeaturedRestaurant
import com.example.cateringplatform.models.FindResturantModel
import com.example.cateringplatform.models.GetCuisineModel
import com.example.cateringplatform.webservice.WebService


class ResturantHomeFragment : Fragment() {

    private var homeRecycler: RecyclerView? = null
    private var homeAdapter: HomeAdapter? = null

    private val featuredResturantList: List<FeaturedRestaurant> = ArrayList<FeaturedRestaurant>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_resturant_home, container, false)

        homeRecycler = view.findViewById(R.id.rv_res_home)
        homeRecycler!!.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        homeRecycler!!.setHasFixedSize(true)

        showProgressBar(activity!!)

        findResturantAPI()

        return view
    }

    fun findResturantAPI() {

        WebService.callFindResturantAPI { responseObj, error ->

            if (error == null) {

                hideProgressBar()
                //TODO the response success code here

                val findResturantModel: FindResturantModel? = responseObj
                homeAdapter = HomeAdapter(context, findResturantModel)
                homeRecycler!!.adapter = homeAdapter

                Log.d("onResponse", "" + responseObj)
            } else {
                hideProgressBar()
                showToast(context!!, "" + error)
                Log.d("onError", "" + responseObj)

        }
        }
    }
}
