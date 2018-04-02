package com.stele.htectestapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    Context context;
    public ArrayList<Item> items;
    //Dialog itemsDialog;

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

        /*recentPlaceDialog = new Dialog(mContext);
        recentPlaceDialog.setContentView(R.layout.dialog_recent_place);
        recentPlaceDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.recentPlacesItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapDialog = (MapView) recentPlaceDialog.findViewById(R.id.dialogMap);
                TextView namePlace = (TextView) recentPlaceDialog.findViewById(R.id.recentPlaceNameDialog);
                TextView addressPlace = (TextView) recentPlaceDialog.findViewById(R.id.recentPlaceAddressDialog);
                namePlace.setText(mRecentPlaces.get(vHolder.getAdapterPosition()).getName());
                addressPlace.setText(mRecentPlaces.get(vHolder.getAdapterPosition()).getAddress());
                Toast.makeText(mContext, vHolder.namePlace.getText(), Toast.LENGTH_SHORT).show();

                MapsInitializer.initialize(mContext);
                mapDialog.onCreate(recentPlaceDialog.onSaveInstanceState());
                mapDialog.onResume();

                mapDialog.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        LatLng vranje = new LatLng(42.55139, 21.90028);

                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(mRecentPlaces.get(vHolder.getAdapterPosition()).getCoordinates()));
                        googleMap.moveCamera(CameraUpdateFactory.zoomTo(18));
                    }
                });

                recentPlaceDialog.show();
            }
        });*/

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
