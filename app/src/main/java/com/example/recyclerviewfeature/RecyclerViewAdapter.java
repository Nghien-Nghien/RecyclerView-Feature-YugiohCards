package com.example.recyclerviewfeature;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<NameIconOnItem> mData;
    private List<Integer> mIcon;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    RecyclerViewAdapter(Context context, ArrayList<NameIconOnItem> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NameIconOnItem cardItem = mData.get(position);
        String cardName = cardItem.getDataName();
        holder.nameTextView.setText(cardName);
        holder.iconImageView.setImageResource(cardItem.getDataIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(mInflater.getContext());
                dialog.setContentView(R.layout.activity_yugicard);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                ImageView imageView = dialog.findViewById(R.id.image_dialog);
                dialog.show();
                if (cardName == "Battlin Boxer Shooting Star") {
                    imageView.setImageResource(R.drawable.battlin_boxer_shooting_star);
                } else if (cardName == "Bynor the Legend of Leviathan") {
                    imageView.setImageResource(R.drawable.bynor_the_legend_of_leviathan);
                } else if (cardName == "Chimeratech Terminal Dragon") {
                    imageView.setImageResource((R.drawable.chimeratech_terminal_dragon));
                } else if (cardName == "Cyberdark Dragon Blade Variant") {
                    imageView.setImageResource(R.drawable.cyberdark_dragon_blade_variant);
                } else if (cardName == "Decode Talker") {
                    imageView.setImageResource(R.drawable.decode_talker);
                } else if (cardName == "Eternatus") {
                    imageView.setImageResource(R.drawable.eternatus);
                } else if (cardName == "Full Ammored Stardust Dragon") {
                    imageView.setImageResource(R.drawable.full_armored_stardust_dragon);
                } else if (cardName == "Gaia the Chaos Knight") {
                    imageView.setImageResource(R.drawable.gaia_the_chaos_knight);
                } else if (cardName == "Giltia the D.KNight Soul Spear") {
                    imageView.setImageResource(R.drawable.giltia_the_d_knight_soul_spear);
                } else if (cardName == "Golden Eyes Idol") {
                    imageView.setImageResource(R.drawable.golden_eyes_idol);
                } else if (cardName == "Legendary Dark Magician") {
                    imageView.setImageResource(R.drawable.legendary_dark_magician);
                } else if (cardName == "Luster Dragon #3") {
                    imageView.setImageResource(R.drawable.luster_dragon__3);
                } else if (cardName == "Mega Lucario") {
                    imageView.setImageResource(R.drawable.mega_lucario);
                } else if (cardName == "Neo Blue Eyes Shining Dragon") {
                    imageView.setImageResource(R.drawable.neo_blue_eyes_shining_dragon);
                } else if (cardName == "Number 39 Utopic Knight") {
                    imageView.setImageResource(R.drawable.number_39_utopic_knight);
                } else if (cardName == "Relinquished Fusion") {
                    imageView.setImageResource(R.drawable.relinquished_fusion);
                } else if (cardName == "Shooting Starburst Dragon") {
                    imageView.setImageResource(R.drawable.shooting_starburst_dragon);
                } else if (cardName == "Stardust Divine Dragon") {
                    imageView.setImageResource(R.drawable.stardust_divine_dragon);
                } else if (cardName == "Urgent Mask Chage") {
                    imageView.setImageResource(R.drawable.urgent_mask_change);
                }
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTextView;
        ImageView iconImageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameYugiohCards);
            iconImageView = itemView.findViewById(R.id.iconYugiohCards);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    NameIconOnItem getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
