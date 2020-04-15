package com.example.movieapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.movieapp.Adapters.SearchActorAdapter;
import com.example.movieapp.Adapters.SearchMovieAdapter;
import com.example.movieapp.Models.ResultsActorItem;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.UI.Movie.MoviesViewModel;
import com.example.movieapp.UI.actor.ActorViewModel;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView search;
    ProgressDialog dialog;
    TextView textView;
    SearchMovieAdapter movieAdapter;
    SearchActorAdapter actorAdapter;
    MoviesViewModel movieViewModel;
    ActorViewModel actorViewModel;
    String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
    }

    private void init() {
        dialog=new ProgressDialog(SearchActivity.this);
        recyclerView = findViewById(R.id.rv_search);
        textView = findViewById(R.id.textView);

        search = findViewById(R.id.btn_search);
        initRecyclerView(recyclerView);
        type = getIntent().getExtras().getString("type");
        actorViewModel  = new ViewModelProvider(this).get(ActorViewModel.class);
        movieViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.show();
                dialog.setContentView(R.layout.test);
                dialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                observeSearchData(type, query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                dialog.show();
                dialog.setContentView(R.layout.test);
                dialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                observeSearchData(type, newText);
                return false;
            }
        });
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
    }

    private void observeSearchData(String type, String query) {
        textView.setVisibility(View.GONE);

        switch (type) {
            case "movie":
                movieViewModel.getSearchMovies(query);
                movieViewModel.getSearchMoviesLiveData().observe(this, new Observer<List<ResultsMovieItem>>() {
                    @Override
                    public void onChanged(List<ResultsMovieItem> resultsMovieItems) {
                        movieAdapter = new SearchMovieAdapter(resultsMovieItems, SearchActivity.this);
                        recyclerView.setAdapter(movieAdapter);
                    }
                });
                break;
            case "actor":
                actorViewModel.getSearchActors(query);
                actorViewModel.getSearchActorsLiveData().observe(this, new Observer<List<ResultsActorItem>>() {
                    @Override
                    public void onChanged(List<ResultsActorItem> resultsItems) {
                        actorAdapter = new SearchActorAdapter(resultsItems, SearchActivity.this);
                        recyclerView.setAdapter(actorAdapter);
                    }
                });
                break;
        }
        dialog.dismiss();

    }
}
