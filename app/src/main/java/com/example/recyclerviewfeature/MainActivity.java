package com.example.recyclerviewfeature;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<NameIconOnItem> cardItems = new ArrayList<>();
        cardItems.add(new NameIconOnItem("Ballom Master of the Death", R.drawable.ballom_master_of_death_yc));
        cardItems.add(new NameIconOnItem("Eternatus", R.drawable.eternatus_yc));
        cardItems.add(new NameIconOnItem("Bynor the Legend of Leviathan", R.drawable.bynor_the_legend_of_leviathan_yc));
        cardItems.add(new NameIconOnItem("Eternatus Eternamax", R.drawable.eternatus_eternamax_yc));
        cardItems.add(new NameIconOnItem("Luster Dragon #3", R.drawable.luster_dragon__3_yc));
        cardItems.add(new NameIconOnItem("Full Ammored Stardust Dragon",R.drawable.full_armored_stardust_dragon_yc));
        cardItems.add(new NameIconOnItem("Neo Blue Eyes Shining Dragon",R.drawable.neo_blue_eyes_shining_dragon_yc));
        cardItems.add(new NameIconOnItem("Relinquished Fusion",R.drawable.relinquished_fusion_yc));
        cardItems.add(new NameIconOnItem("Shooting Starburst Dragon",R.drawable.shooting_starburst__dragon_yc));
        cardItems.add(new NameIconOnItem("Stardust Divine Dragon",R.drawable.stardust_divine_dragon_yc));
        cardItems.add(new NameIconOnItem("Urgent Mask Chage",R.drawable.urgent_mask_change_yc));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvYugiohCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, cardItems);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onItemClick(View view, int position) {
    }

}