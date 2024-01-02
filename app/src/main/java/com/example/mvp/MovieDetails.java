package com.example.mvp;

 import android.content.Intent;
 import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mvp.models.MovieModel;

public class MovieDetails extends AppCompatActivity {
    private ImageView imageViewDetails;
    private TextView movieTitleTextView, movieDurationTextView, movieLanguageTextView,
            movieOverviewTextView, movieReleaseDateTextView;

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // Get references to views
        imageViewDetails = findViewById(R.id.imageView_details);
        movieTitleTextView = findViewById(R.id.movieTitleTextView);
        ratingBar = findViewById(R.id.rating_bar);
        movieDurationTextView = findViewById(R.id.movieDurationTextView);
        movieLanguageTextView = findViewById(R.id.movieLanguageTextView);
        movieOverviewTextView = findViewById(R.id.movieOverviewTextView);
        movieReleaseDateTextView = findViewById(R.id.movieReleaseDateTextView);

        // Get data from Intent
        getDataFromIntent();
    }

    public void onHomeButtonClick(View view) {
        Intent intent = new Intent(this, MovieListActivity.class);
        startActivity(intent);
    }

    private void getDataFromIntent() {
        if (getIntent().hasExtra("movie")) {
            MovieModel movieModel = getIntent().getParcelableExtra("movie");

            // Set values to views
            movieTitleTextView.setText("TITLE:"+" "+ movieModel.getTitle());
            movieDurationTextView.setText("DURATION:"+" " +String.valueOf(movieModel.getRuntime())+""+"-MINUTES");
            movieLanguageTextView.setText("LANGUAGE:"+" " +movieModel.getOriginal_language());
            movieOverviewTextView.setText("OVERVIEW:"+" " +movieModel.getMovie_overview());
            movieReleaseDateTextView.setText("RELEASE_DATE:"+" " +movieModel.getRelease_date());

            // Set the original rating without dividing by 2
            ratingBar.setRating((float) movieModel.getVote_average());

            ratingBar.setIsIndicator(true);//to disable the user not to act on star

            // Load image using Glide
            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500/" + movieModel.getPoster_path())
                    .into(imageViewDetails);
        }
    }
}