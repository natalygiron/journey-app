package com.example.journeyapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.journeyapp.network.ImageRequest;
import com.example.journeyapp.network.JourneyEntry;

import java.util.List;

public class JourneyCardRecyclerViewAdapter extends RecyclerView.Adapter<JourneyCardViewHolder> {

    private List<JourneyEntry> journeyList;
    private ImageRequest imageRequest;

    JourneyCardRecyclerViewAdapter(List<JourneyEntry> journeyList) {
        this.journeyList = journeyList;
        imageRequest = ImageRequest.getInstance();
    }

    @NonNull
    @Override
    public JourneyCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.journey_card,parent,false);
        return new JourneyCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull JourneyCardViewHolder holder, int position) {
        if(journeyList != null && position < journeyList.size()) {
            JourneyEntry journey = journeyList.get(position);
            holder.journeyTitle.setText(journey.title);
            holder.journeyLocation.setText(journey.location);
            imageRequest.setImageFromUrl(holder.journeyImage, journey.url);
        }
    }

    @Override
    public int getItemCount() {return journeyList.size();}

}
