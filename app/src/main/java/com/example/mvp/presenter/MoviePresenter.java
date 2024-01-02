package com.example.mvp.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.mvp.models.MovieModel;
import com.example.mvp.repositories.MovieRepositoryContract;

import java.util.List;

public class MoviePresenter implements MovieRepositoryContract.Presenter {
    private final MovieRepositoryContract.Model model;
    private final MovieRepositoryContract.View view;

    private MPInterface mpInterface;


    public MoviePresenter(MovieRepositoryContract.Model model, MovieRepositoryContract.View view,MPInterface z) {
        this.model = model;
        this.view = view;
        this.mpInterface=z;
    }

    public void onMovieClick(String position) {
        mpInterface.setdata(position);

    }

    @Override
    public void onCategoryClick(String category) {

    }

    @Override
    public void onViewCreated() {
        model.getMovies().observe((LifecycleOwner) view, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                view.displayMovies(movieModels);
            }
        });

        model.searchMovieApi("war", 1);
    }

    @Override
    public void onDestroy() {
    }

    public  interface MPInterface{
        void setdata(String a);
    }
}