package com.example.magicbells;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    RecyclerView recyclerView, recyclerViewStarter, recyclerViewMainCourse;
    SpecialFoodListAdapter specialFoodListAdapter;
    StarterFoodListAdapter starterFoodListAdapter;
    MainFoodListAdapter mainFoodListAdapter;
    ArrayList<FoodData> starterFoodList;
    ArrayList<FoodData> mainFoodList;
    ArrayList<FoodData> specialFoodList;
    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //featching id
        recyclerView = view.findViewById(R.id.recycler_special_food);
        recyclerViewStarter = view.findViewById(R.id.recycler_starter_food);
        recyclerViewMainCourse = view.findViewById(R.id.recycler_maincourse_food);

        //database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Food");

        //for different food category
        specialFoodList = new ArrayList<>();
        starterFoodList = new ArrayList<>();
        mainFoodList = new ArrayList<>();

        //add food list from firebase
        addFoodList();

        specialFoodListAdapter = new SpecialFoodListAdapter(container.getContext(), specialFoodList);
        starterFoodListAdapter = new StarterFoodListAdapter(container.getContext(), starterFoodList);
        mainFoodListAdapter = new MainFoodListAdapter(container.getContext(),mainFoodList);


        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setAdapter(specialFoodListAdapter);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewStarter.setAdapter(starterFoodListAdapter);
        recyclerViewStarter.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, true));

        recyclerViewMainCourse.setAdapter(mainFoodListAdapter);
        recyclerViewMainCourse.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.HORIZONTAL, true));

        return view;

    }

    private void addFoodList() {
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                FoodData foodData = snapshot.getValue(FoodData.class);
                specialFoodList.add(foodData);
                starterFoodList.add(foodData);
                mainFoodList.add(foodData);

                specialFoodListAdapter.notifyDataSetChanged();
                starterFoodListAdapter.notifyDataSetChanged();
                mainFoodListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}