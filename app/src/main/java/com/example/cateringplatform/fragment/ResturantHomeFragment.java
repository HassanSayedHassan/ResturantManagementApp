package com.example.cateringplatform.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringplatform.R;
import com.example.cateringplatform.adapters.HomeAdapter;
import com.example.cateringplatform.api.ApiServices;
import com.example.cateringplatform.apiclient.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResturantHomeFragment extends Fragment {

    private RecyclerView homeRecycler;
    private HomeAdapter homeAdapter;
    private ApiServices apiServices;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_resturant_home,container,false);

        homeRecycler = view.findViewById(R.id.rv_res_home);
        homeRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        homeRecycler.setHasFixedSize(true);

        apiServices = APIClient.getRetrofit().create(ApiServices.class);
        Call<String> call = apiServices.findResturantAPI();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                homeAdapter = new HomeAdapter();
                homeRecycler.setAdapter(homeAdapter);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


        return view;
    }
}
