package com.example.magicbells;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class StarterFoodListAdapter extends RecyclerView.Adapter<StarterFoodListAdapter.StarterFoodListViewHolder> {

    Context context;
    ArrayList<FoodData> foodList;

    public StarterFoodListAdapter(Context context, ArrayList<FoodData> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public StarterFoodListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_list, parent, false);
        return new StarterFoodListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarterFoodListViewHolder holder, int position) {
        FoodData foodData = foodList.get(position);
        Picasso.get()
                .load(foodData.getImageLink())
                .fit().centerCrop().into(holder.imgFood);
        holder.txtFoodName.setText(foodData.getFoodName());
        holder.txtFoodPrice.setText(foodData.getFoodPrice());

        holder.imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ProductDetailActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class StarterFoodListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView txtFoodName, txtFoodPrice;

        public StarterFoodListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_food);
            txtFoodName = itemView.findViewById(R.id.txt_food_name);
            txtFoodPrice = itemView.findViewById(R.id.txt_food_price);
        }
    }
}
