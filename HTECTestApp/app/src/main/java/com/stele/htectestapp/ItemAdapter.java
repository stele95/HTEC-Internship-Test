package com.stele.htectestapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context context;
    public ArrayList<Item> items;
    Dialog itemDialog;

    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        final ItemViewHolder itemViewHolder = new ItemViewHolder(v);

        //Dialog

        itemDialog = new Dialog(context);
        itemDialog.setContentView(R.layout.dialog_item);
        itemDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        itemViewHolder.item_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TextView title = (TextView) itemDialog.findViewById(R.id.item_title_dialog);
                TextView description = (TextView) itemDialog.findViewById(R.id.item_description_dialog);
                ImageView imageView = itemDialog.findViewById(R.id.item_image_dialog);


                Glide.with(context).load(items.get(itemViewHolder.getAdapterPosition()).getImage()).into(imageView);

                title.setText(items.get(itemViewHolder.getAdapterPosition()).getTitle());
                description.setText(items.get(itemViewHolder.getAdapterPosition()).getDescription());

                Toast.makeText(context, "Loading image, please wait...",Toast.LENGTH_LONG).show();

                itemDialog.show();


            }
        });

        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.item_title.setText(items.get(position).getTitle());
        holder.item_description.setText(items.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        CardView item_card;
        TextView item_title;
        TextView item_description;


        public ItemViewHolder(View itemView) {
            super(itemView);

            item_card = (CardView) itemView.findViewById(R.id.item_card);
            item_title = (TextView) itemView.findViewById(R.id.item_title);
            item_description = (TextView) itemView.findViewById(R.id.item_description);;
        }
    }
}
