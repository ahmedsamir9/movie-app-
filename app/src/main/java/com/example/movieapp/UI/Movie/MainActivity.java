package com.example.movieapp.UI.Movie;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.Adapters.MoviesPlayingNowAdapter;
import com.example.movieapp.Adapters.MoviesPopularAdapter;
import com.example.movieapp.Adapters.MoviesTopRatedAdapter;
import com.example.movieapp.Adapters.MoviesUpComingAdapter;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.UI.SearchActivity;
import com.github.islamkhsh.CardSliderViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton fabMain, fabOne, fabTwo, fabThree;
    private Float translationY = 100f;
    private TextView textView, textView2, textView3, textView4;
    private OvershootInterpolator interpolator = new OvershootInterpolator();
    private Boolean isMenuOpen = false;

    RecyclerView rv_popular, rv_up_coming,  rv_playing_now;
    MoviesViewModel movieViewModel;
    MoviesPopularAdapter popularAdapter;
    MoviesPlayingNowAdapter playingNowAdapter;
    MoviesTopRatedAdapter topRatedAdapter;
    MoviesUpComingAdapter upComingAdapter;
    CardSliderViewPager cardSliderViewPager;
    ProgressDialog dialog;
    MutableLiveData<List<ResultsMovieItem>> mutableLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFabMenu();
        initViews();
        getLiveData();
    }

    private void initViews() {
        dialog=new ProgressDialog(this);
        dialog.show();
        dialog.setContentView(R.layout.test);
        dialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
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
        movieViewModel =new ViewModelProvider(this).get(MoviesViewModel.class);
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
                dialog.dismiss();
            }
        });

    }

    private void setAdapterData(String data, List<ResultsMovieItem> resultsMovieItems) {
        switch (data) {
            case "Up Coming":
                upComingAdapter = new MoviesUpComingAdapter(resultsMovieItems,MainActivity.this);
                rv_up_coming.setAdapter(upComingAdapter);
                break;
            case "Top Rated":
                topRatedAdapter = new MoviesTopRatedAdapter(resultsMovieItems,MainActivity.this);
                cardSliderViewPager.setAdapter(topRatedAdapter);
                break;
            case "Playing now":
                playingNowAdapter = new MoviesPlayingNowAdapter(resultsMovieItems,MainActivity.this);
                rv_playing_now.setAdapter(playingNowAdapter);
                break;
            case "Popular":
                popularAdapter = new MoviesPopularAdapter(resultsMovieItems,MainActivity.this);
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



    private void initFabMenu() {
        textView2 = findViewById(R.id.open2);
        textView3 = findViewById(R.id.open3);
        textView4 = findViewById(R.id.open4);

        fabMain = findViewById(R.id.fb_search);
        fabOne = findViewById(R.id.fb_actor);
        fabTwo = findViewById(R.id.fb_movie);

        textView4.setAlpha(0f);

        textView2.setAlpha(0f);
        textView3.setAlpha(0f);

        fabOne.setAlpha(0f);
        fabTwo.setAlpha(0f);
        textView4.setTranslationY(translationY);
        textView2.setTranslationY(translationY);
        textView3.setTranslationY(translationY);

        fabOne.setTranslationY(translationY);
        fabTwo.setTranslationY(translationY);

        fabMain.setOnClickListener(this);
        fabOne.setOnClickListener(this);
        fabTwo.setOnClickListener(this);
    }

    private void openMenu() {
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(interpolator).rotation(45f).setDuration(300).start();

        textView4.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        textView2.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        textView3.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();

        fabOne.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();


    }

    private void closeMenu() {
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(interpolator).rotation(0f).setDuration(300).start();

        textView4.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        textView2.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        textView3.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

        fabOne.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fb_search:
                if (isMenuOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
                break;
            case R.id.fb_movie:
                Intent intentMovie=new Intent(MainActivity.this, SearchActivity.class);
                intentMovie.putExtra("type","movie");
                startActivity(intentMovie);

                closeMenu();
                break;
            case R.id.fb_actor:
                Intent intentActor=new Intent(MainActivity.this, SearchActivity.class);
                intentActor.putExtra("type","actor");
                startActivity(intentActor);
                closeMenu();
                break;
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
