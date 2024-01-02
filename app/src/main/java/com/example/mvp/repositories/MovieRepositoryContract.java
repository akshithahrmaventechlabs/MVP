package com.example.mvp.repositories;


import androidx.lifecycle.LiveData;

import com.example.mvp.models.MovieModel;

import java.util.List;

public interface MovieRepositoryContract {
    interface Model {
        void searchMovieApi(String query, int pageNumber);

        LiveData<List<MovieModel>> getPop();

        void searchNextPage();

        void searchMoviePop(int pageNumber);

        LiveData<List<MovieModel>> getMovies();
    }

    interface Presenter {
        void onCategoryClick(String category);
        void onViewCreated();
        void onDestroy();
    }

    interface View {
        void displayMovies(List<MovieModel> movies);
        void showToast(String message);
    }
}