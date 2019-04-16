package com.example.cateringplatform.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cateringplatform.R
import com.example.cateringplatform.Utills.showToast
import com.example.cateringplatform.adapters.HomeAdapter
import com.example.cateringplatform.webservice.WebService


class ResturantHomeFragment : Fragment() {

    private var homeRecycler: RecyclerView? = null
    private var homeAdapter: HomeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_resturant_home, container, false)

        homeRecycler = view.findViewById(R.id.rv_res_home)
        homeRecycler!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        homeRecycler!!.setHasFixedSize(true)

        WebService.callFindResturantAPI { responseObj,error ->

            if (error == null){

                //TODO the response success code here
                homeAdapter = HomeAdapter()
                homeRecycler!!.adapter = homeAdapter
            } else{
               showToast(context!!,""+error)
            }
        }

        return view
    }
}
