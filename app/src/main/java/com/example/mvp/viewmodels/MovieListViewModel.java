package com.example.mvp.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvp.models.MovieModel;
import com.example.mvp.repositories.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    private MovieRepository movieRepository;
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    // Constructor
    public MovieListViewModel() {
        movieRepository = MovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies() {
        return movieRepository.getMovies();
    }

    public LiveData<List<MovieModel>> getPop() {
        return movieRepository.getPop();
    }

    public void searchMovieApi(String query, int pageNumber) {
        movieRepository.searchMovieApi(query, pageNumber);
    }

    public void searchMoviePop(int pageNumber) {
        movieRepository.searchMoviePop(pageNumber);
    }

    public void searchNextPage() {
        movieRepository.searchNextPage();
    }

    public LiveData<String> getError() {
        return errorLiveData;
    }

    // Method to set an error message
    public void setError(String errorMessage) {
        errorLiveData.setValue(errorMessage);
    }
}
















//package com.newproject.tmdb.viewmodels;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//
//import com.newproject.tmdb.models.MovieModel;
//import com.newproject.tmdb.repositories.MovieRepository;
//
//import java.util.List;
//
//public class MovieListViewModel extends ViewModel {
//
//    private MovieRepository movieRepository;
//
//
////    Constructor
//    public MovieListViewModel(){
//        movieRepository = MovieRepository.getInstance();
//    }
//
//    public LiveData<List<MovieModel>> getMovies(){
//        return movieRepository.getMovies();
//    }
//    public LiveData<List<MovieModel>> getPop(){
//        return movieRepository.getPop();
//    }
//
//
//    public void searchMovieApi(String query, int pageNumber){
//        movieRepository.searchMovieApi(query, pageNumber);
//    }
//    public void searchMoviePop( int pageNumber){
//        movieRepository.searchMoviePop(pageNumber);
//    }
//
//    public void searchNextPage(){
//        movieRepository.searchNextPage();
//    }
//
//
//}

