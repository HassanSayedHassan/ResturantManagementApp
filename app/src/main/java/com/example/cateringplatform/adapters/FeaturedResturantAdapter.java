package com.example.cateringplatform.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cateringplatform.R;

public class FeaturedResturantAdapter extends RecyclerView.Adapter<FeaturedResturantAdapter.FeaturedHolder> {
    @NonNull
    @Override
    public FeaturedHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_featured_resturant,viewGroup,false);
        return new FeaturedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedHolder featuredHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class FeaturedHolder extends RecyclerView.ViewHolder {
       private ImageView featuredResIcon;
       private TextView featuredResTV;
        public FeaturedHolder(@NonNull View itemView) {
            super(itemView);
            featuredResIcon = itemView.findViewById(R.id.iv_feat_food);
            featuredResTV = itemView.findViewById(R.id.tv_feat_resturant);
        }
    }
}
