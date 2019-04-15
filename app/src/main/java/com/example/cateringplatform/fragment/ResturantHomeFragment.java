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

public class ResturantHomeFragment extends Fragment {

    private RecyclerView homeRecycler;
    private HomeAdapter homeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_resturant_home,container,false);

        homeRecycler = view.findViewById(R.id.rv_res_home);
        homeRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        homeRecycler.setHasFixedSize(true);

        homeAdapter = new HomeAdapter();
        homeRecycler.setAdapter(homeAdapter);

        return view;
    }
}
