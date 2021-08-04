package com.example.recyclerviewfeature;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    RecyclerViewAdapter(Context context, List<String> data) {
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
        String card = mData.get(position);
        holder.myTextView.setText(card);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(mInflater.getContext());
                dialog.setContentView(R.layout.activity_main);
                ImageView imageView = dialog.findViewById(R.id.image_dialog);
                dialog.show();
                if (card == "Eternatus") {
                    imageView.setImageResource(R.drawable.eternatus_yc);
                } else if (card == "Ballom Master of the Death") {
                    imageView.setImageResource(R.drawable.ballom_master_of_death_yc);
                } else if (card == "Bynor the Legend of Leviathan") {
                    imageView.setImageResource((R.drawable.bynor_the_legend_of_leviathan_yc));
                } else if (card == "Eternatus Eternamax") {
                    imageView.setImageResource(R.drawable.eternatus_eternamax_yc);
                } else if (card == "Luster Dragon #3") {
                    imageView.setImageResource(R.drawable.luster_dragon__3_yc);
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
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvYugiohCards);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
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
