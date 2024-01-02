package com.example.mvp.repositories;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.LiveData;
import com.example.mvp.models.MovieModel;
import com.example.mvp.request.MovieApiClient;

import java.util.List;

public class MovieRepository implements MovieRepositoryContract.Model {
    private MutableLiveData<List<MovieModel>> mMovies;
    private MutableLiveData<List<MovieModel>> mMoviesPop;

    private static MovieRepository instance;

    private MovieApiClient movieApiClient;

    private String mQuery;
    private int mPageNumber;

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository() {
        movieApiClient = MovieApiClient.getInstance();
        mMovies = new MutableLiveData<>();
        mMoviesPop = new MutableLiveData<>();
    }

    @Override
    public void searchMovieApi(String query, int pageNumber) {
        mQuery = query;
        mPageNumber = pageNumber;
        movieApiClient.searchMoviesApi(query, pageNumber);
    }

    @Override
    public void searchMoviePop(int pageNumber) {
        movieApiClient.searchMoviesPop(pageNumber);
    }

    @Override
    public LiveData<List<MovieModel>> getMovies() {
        return mMovies;
    }

    @Override
    public LiveData<List<MovieModel>> getPop() {
        return mMoviesPop;
    }

    @Override
    public void searchNextPage() {
        searchMovieApi(mQuery, mPageNumber + 1);
    }

}