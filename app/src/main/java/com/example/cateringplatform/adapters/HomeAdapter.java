package com.example.cateringplatform.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cateringplatform.R;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int VIEW_TYPE_FOOD_TYPE = 0;
    public static final int VIEW_TYPE_FEATURE_RESTURANT = 1;
    public static final int VIEW_TYPE_AVAILABLE_RESTURANT = 2;

    private Context context;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (i == VIEW_TYPE_FOOD_TYPE) {
            View foodType = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_food_type, viewGroup, false);
            return new FoodTypeHolder(foodType);
        } else if (i == VIEW_TYPE_FEATURE_RESTURANT) {
            View featureResturant = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_feature_resturant, viewGroup, false);
            return new FeatureResturantHolder(featureResturant);
        } else {

            View availableResturant = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_available_resturant, viewGroup, false);
            return new AvailableResturantHolder(availableResturant);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        final int itemType =getItemViewType(i);

        if (itemType==VIEW_TYPE_FOOD_TYPE){

            final FoodTypeHolder foodTypeHolder = (FoodTypeHolder) viewHolder;
            FoodTypeAdapter foodTypeAdapter = new FoodTypeAdapter();
            foodTypeHolder.foodTypeRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            foodTypeHolder.foodTypeRecycler.setAdapter(foodTypeAdapter);
        } else if (itemType == VIEW_TYPE_FEATURE_RESTURANT) {

            final FeatureResturantHolder featureResturantHolder = (FeatureResturantHolder) viewHolder;
            FeaturedResturantAdapter featuredResturantAdapter = new FeaturedResturantAdapter();
            featureResturantHolder.featureResturantRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            featureResturantHolder.featureResturantRecycler.setAdapter(featuredResturantAdapter);
        } else {

            final AvailableResturantHolder availableResturantHolder = (AvailableResturantHolder) viewHolder;
            AvailableResturantAdapter availableResturantAdapter = new AvailableResturantAdapter();
            availableResturantHolder.availableResturantRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
            availableResturantHolder.availableResturantRecycler.setAdapter(availableResturantAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return VIEW_TYPE_FOOD_TYPE;
        } else if (position==1){
            return VIEW_TYPE_FEATURE_RESTURANT;
        }
        else {
            return VIEW_TYPE_AVAILABLE_RESTURANT;
        }
    }


    public class FoodTypeHolder extends RecyclerView.ViewHolder {
        private RecyclerView foodTypeRecycler;
        public FoodTypeHolder(@NonNull View itemView) {
            super(itemView);
            foodTypeRecycler = itemView.findViewById(R.id.rv_food_type);
        }
    }

    public class FeatureResturantHolder extends RecyclerView.ViewHolder {
        private RecyclerView featureResturantRecycler;
        public FeatureResturantHolder(@NonNull View itemView) {
            super(itemView);
            featureResturantRecycler = itemView.findViewById(R.id.rv_featured_resturant);
        }
    }

    public class AvailableResturantHolder extends RecyclerView.ViewHolder {
        private TextView availableTV;
        private RecyclerView availableResturantRecycler;
        public AvailableResturantHolder(@NonNull View itemView) {
            super(itemView);
            availableTV = itemView.findViewById(R.id.tv_available_on_date);
            availableResturantRecycler = itemView.findViewById(R.id.rv_available_resturant);
        }
    }
}
