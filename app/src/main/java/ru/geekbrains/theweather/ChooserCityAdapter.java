package ru.geekbrains.theweather;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChooserCityAdapter extends RecyclerView.Adapter<ChooserCityAdapter.ViewHolder> {
    private String[] cities;
    private OnItemClickListener itemClickListener;

    public ChooserCityAdapter(String[] cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView view = new TextView(viewGroup.getContext());
        ViewHolder vh = new ViewHolder(view);
        vh.setOnClickListener(itemClickListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setText(cities[i]);
    }

    @Override
    public int getItemCount() {
        return cities.length;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(String city);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cityView;
        public ViewHolder(@NonNull TextView itemView) {
            super(itemView);
            cityView = itemView;
        }

        public void setOnClickListener(final OnItemClickListener itemClickListener) {
            cityView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    // Проверяем ее на корректность
                    if (adapterPosition == RecyclerView.NO_POSITION) return;
                    itemClickListener.onItemClick(((TextView)v).getText().toString());
                }
            });
        }

        public void setText(String city) {
            cityView.setText(city);
        }
    }
}
