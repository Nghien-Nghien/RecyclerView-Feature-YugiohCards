package com.example.recyclerviewfeature;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class YugiCardActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yugicard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Yugi Cards");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SlidrInterface slide = Slidr.attach(this);

        // data to populate the RecyclerView with
        ArrayList<NameIconOnItem> cardItems = new ArrayList<>();
        cardItems.add(new NameIconOnItem("Battlin Boxer Shooting Star", R.drawable.battlin_boxer_shooting_star));
        cardItems.add(new NameIconOnItem("Bynor the Legend of Leviathan", R.drawable.bynor_the_legend_of_leviathan));
        cardItems.add(new NameIconOnItem("Chimeratech Terminal Dragon", R.drawable.chimeratech_terminal_dragon));
        cardItems.add(new NameIconOnItem("Cyberdark Dragon Blade Variant", R.drawable.cyberdark_dragon_blade_variant));
        cardItems.add(new NameIconOnItem("Decode Talker", R.drawable.decode_talker));
        cardItems.add(new NameIconOnItem("Eternatus", R.drawable.eternatus));
        cardItems.add(new NameIconOnItem("Full Ammored Stardust Dragon", R.drawable.full_armored_stardust_dragon));
        cardItems.add(new NameIconOnItem("Gaia the Chaos Knight", R.drawable.gaia_the_chaos_knight));
        cardItems.add(new NameIconOnItem("Giltia the D.KNight Soul Spear", R.drawable.giltia_the_d_knight_soul_spear));
        cardItems.add(new NameIconOnItem("Golden Eyes Idol", R.drawable.golden_eyes_idol));
        cardItems.add(new NameIconOnItem("Legendary Dark Magician", R.drawable.legendary_dark_magician));
        cardItems.add(new NameIconOnItem("Luster Dragon #3",R.drawable.luster_dragon__3));
        cardItems.add(new NameIconOnItem("Mega Lucario",R.drawable.mega_lucario));
        cardItems.add(new NameIconOnItem("Neo Blue Eyes Shining Dragon",R.drawable.neo_blue_eyes_shining_dragon));
        cardItems.add(new NameIconOnItem("Number 39 Utopic Knight",R.drawable.number_39_utopic_knight));
        cardItems.add(new NameIconOnItem("Relinquished Fusion",R.drawable.relinquished_fusion));
        cardItems.add(new NameIconOnItem("Shooting Starburst Dragon",R.drawable.shooting_starburst_dragon));
        cardItems.add(new NameIconOnItem("Stardust Divine Dragon",R.drawable.stardust_divine_dragon));
        cardItems.add(new NameIconOnItem("Urgent Mask Change",R.drawable.urgent_mask_change));

        Collections.sort(cardItems, new Comparator<NameIconOnItem>() {
            @Override
            public int compare(NameIconOnItem item1, NameIconOnItem item2) {
                return item1.getDataName().compareToIgnoreCase(item2.getDataName());
            }
        });

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvYugiohCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, cardItems);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
    }

}