package com.example.journeyapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class JourneyCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView journeyImage;
    public TextView journeyTitle;
    public TextView journeyLocation;

    public JourneyCardViewHolder(@NonNull View itemView) {
        super(itemView);
        journeyImage = itemView.findViewById(R.id.journey_image);
        journeyTitle = itemView.findViewById(R.id.journey_title);
        journeyLocation = itemView.findViewById(R.id.journey_location);
    }
}
