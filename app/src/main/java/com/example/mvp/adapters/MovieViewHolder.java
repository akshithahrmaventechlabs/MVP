package com.example.mvp.adapters;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title;
    TextView movie_category;
    TextView duration;
    public ImageView imageView;
    public ImageView starIcon;
    public TextView numericRating;

    //    Click Listener
    OnMovieListener onMovieListener;

    public MovieViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
        super(itemView);


        this.onMovieListener=onMovieListener;

        title = itemView.findViewById(R.id.movie_title);
//        movie_category = itemView.findViewById(R.id.movie_category);
//        duration = itemView.findViewById(R.id.movie_duration);

        imageView = itemView.findViewById(R.id.movie_img);
        numericRating = itemView.findViewById(R.id.numeric_rating); // Add this line for numeric rating
//        starIcon = itemView.findViewById(R.id.star_icon);




        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        onMovieListener.onMovieClick(getAdapterPosition());

    }
}

