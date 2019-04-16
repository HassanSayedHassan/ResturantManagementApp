package com.example.cateringplatform.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cateringplatform.R;

public class AvailableResturantAdapter extends RecyclerView.Adapter<AvailableResturantAdapter.AvailResHolder> {
    @NonNull
    @Override
    public AvailResHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_available_resturant,viewGroup,false);
        return new AvailResHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvailResHolder availResHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class AvailResHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public AvailResHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv_res_name);
        }
    }
}
