package com.milanapp.covid_19tracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.milanapp.covid_19tracker.DetaiActivity;
import com.milanapp.covid_19tracker.Model.MainStatisticModel;
import com.milanapp.covid_19tracker.Model.RegionDatum;
import com.milanapp.covid_19tracker.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StatesAdapter extends RecyclerView.Adapter<StatesAdapter.StatesViewHolder> {

    private Context context;
    List<RegionDatum> regionDatumList;



    public StatesAdapter(Context context, List<RegionDatum> regionDatumList) {
        this.context = context;
        this.regionDatumList = regionDatumList;
    }

    @NonNull
    @Override
    public StatesViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.item_layout,parent,false);
        final StatesViewHolder holder =new StatesViewHolder(view);
        holder.card_view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetaiActivity.class);

                intent.putExtra("region",regionDatumList.get(holder.getAdapterPosition()).getRegion());
                intent.putExtra("totalCases",regionDatumList.get(holder.getAdapterPosition()).getTotalCases());
                intent.putExtra("totalInfected",regionDatumList.get(holder.getAdapterPosition()).getTotalInfected());
                intent.putExtra("recovered",regionDatumList.get(holder.getAdapterPosition()).getRecovered());
                intent.putExtra("deceased",regionDatumList.get(holder.getAdapterPosition()).getDeceased());

                context.startActivity(intent);

            }
        });

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull StatesViewHolder holder, int position) {

        holder.tv_stats_name.setText(regionDatumList.get(position).getRegion());

    }

    @Override
    public int getItemCount() {
        return regionDatumList.size();
    }

    public class StatesViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_stats_name;
        private CardView card_view_container;
        public StatesViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_stats_name=itemView.findViewById(R.id.tv_stats_name);
            card_view_container=itemView.findViewById(R.id.card_view_container);
        }
    }
}
