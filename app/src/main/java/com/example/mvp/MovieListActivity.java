package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.adapters.MovieRecyclerView;
import com.example.mvp.adapters.OnMovieListener;
import com.example.mvp.models.MovieModel;
import com.example.mvp.presenter.MoviePresenter;
import com.example.mvp.repositories.MovieRepository;
import com.example.mvp.repositories.MovieRepositoryContract;

import java.util.List;

public class MovieListActivity extends AppCompatActivity implements MovieRepositoryContract.View, OnMovieListener,MoviePresenter.MPInterface {
    private MoviePresenter presenter;
    private MovieRecyclerView movieRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecyclerViewAdapter = new MovieRecyclerView(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(movieRecyclerViewAdapter);

        presenter = new MoviePresenter(MovieRepository.getInstance(), this,this);
        presenter.onViewCreated();
    }

    @Override
    public void displayMovies(List<MovieModel> movies) {
        movieRecyclerViewAdapter.setmMovies(movies);
    }

    @Override
    public void showToast(String message) {
        // Handle displaying toast...
    }

    @Override
    public void onMovieClick(int position) {
        presenter.onMovieClick("ab");
    }

    @Override
    public void setdata(String a) {
        Toast.makeText(this, "display", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onCategoryClick(String category) {
        presenter.onCategoryClick(category);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}