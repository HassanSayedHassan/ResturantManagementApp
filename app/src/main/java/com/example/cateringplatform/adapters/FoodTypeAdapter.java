package com.example.cateringplatform.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cateringplatform.R;

public class FoodTypeAdapter extends RecyclerView.Adapter<FoodTypeAdapter.TypeHolderFood> {
    @NonNull
    @Override
    public TypeHolderFood onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_food_type,viewGroup,false);
        return new TypeHolderFood(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeHolderFood typeHolderFood, int i) {
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class TypeHolderFood extends RecyclerView.ViewHolder {
        private TextView foodTypeTV;
        public TypeHolderFood(@NonNull View itemView) {
            super(itemView);

            foodTypeTV = itemView.findViewById(R.id.tv_food_type);
        }
    }
}
