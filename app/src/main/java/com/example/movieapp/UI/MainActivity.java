package com.example.movieapp.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.Adapters.MoviesPlayingNowAdapter;
import com.example.movieapp.Adapters.MoviesPopularAdapter;
import com.example.movieapp.Adapters.MoviesTopRatedAdapter;
import com.example.movieapp.Adapters.MoviesUpComingAdapter;
import com.example.movieapp.Adapters.ScrollerAdapter;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.WebServices.MoviesViewModel;
import com.github.islamkhsh.CardSliderViewPager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MoviesViewModel movieViewModel;
    RecyclerView rv_popular, rv_up_coming,  rv_playing_now;
    MoviesPopularAdapter popularAdapter;
    MoviesPlayingNowAdapter playingNowAdapter;
    MoviesTopRatedAdapter topRatedAdapter;
    MoviesUpComingAdapter upComingAdapter;
    CardSliderViewPager cardSliderViewPager;
    ScrollerAdapter scrollerAdapter;
    MutableLiveData<List<ResultsMovieItem>> mutableLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getLiveData();
    }

    private void initViews() {
        rv_popular = findViewById(R.id.rv_popular);
        rv_playing_now = findViewById(R.id.rv_playing_now);
        cardSliderViewPager = findViewById(R.id.rv_top_rated);
        rv_up_coming = findViewById(R.id.rv_up_coming);
        initRecyclerView(rv_popular);
        initRecyclerView(rv_playing_now);
        initRecyclerView(rv_up_coming);
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
    }

    private void getLiveData() {
        mutableLiveData=new MutableLiveData<>();
        movieViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        movieViewModel.getTopRatedMovies(1);
        initLiveData("Top Rated");
        movieViewModel.getUpComingMovies(1);
        initLiveData("Up Coming");
        movieViewModel.getPopularMovies(1);
        initLiveData("Popular");
        movieViewModel.getPlayingNowMovies(1);
        initLiveData("Playing now");

    }

    private void observeData(String type) {
        mutableLiveData.observe(this, new Observer<List<ResultsMovieItem>>() {
            @Override
            public void onChanged(List<ResultsMovieItem> resultsMovieItems) {
                setAdapterData(type,resultsMovieItems);
            }
        });

    }

    private void setAdapterData(String data, List<ResultsMovieItem> resultsMovieItems) {
        switch (data) {
            case "Up Coming":
                upComingAdapter = new MoviesUpComingAdapter(resultsMovieItems);
                rv_up_coming.setAdapter(upComingAdapter);
                break;
            case "Top Rated":
                topRatedAdapter = new MoviesTopRatedAdapter(resultsMovieItems);
                cardSliderViewPager.setAdapter(topRatedAdapter);
                break;
            case "Playing now":
                playingNowAdapter = new MoviesPlayingNowAdapter(resultsMovieItems);
                rv_playing_now.setAdapter(playingNowAdapter);
                break;
            case "Popular":
                popularAdapter = new MoviesPopularAdapter(resultsMovieItems);
                rv_popular.setAdapter(popularAdapter);

                break;
        }

    }
    private void initLiveData(String data) {
        switch (data) {
            case "Up Coming":
                mutableLiveData=movieViewModel.getUpComingMoviesMutableLiveData();
                observeData(data);
                break;
            case "Top Rated":
                mutableLiveData=movieViewModel.getTopRatedMoviesMutableLiveData();
                observeData(data);
                break;
            case "Playing now":
                mutableLiveData=movieViewModel.getPlayingNowMoviesMutableLiveData();
                observeData(data);
                break;
            case "Popular":
                mutableLiveData=movieViewModel.getPopularMoviesMutableLiveData();
                observeData(data);
                break;
        }
    }
}
