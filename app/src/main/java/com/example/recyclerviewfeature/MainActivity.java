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
        ArrayList<String> cardNames = new ArrayList<>();
        cardNames.add("Ballom Master of the Death");
        cardNames.add("Eternatus");
        cardNames.add("Bynor the Legend of Leviathan");
        cardNames.add("Eternatus Eternamax");
        cardNames.add("Luster Dragon #3");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvYugiohCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, cardNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {}

}