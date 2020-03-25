package com.example.movieapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Adapters.ActorsMoveAdapter;
import com.example.movieapp.Models.CastItem;
import com.example.movieapp.Models.GenresItem;
import com.example.movieapp.Models.MovieDetailsResponse;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.R;
import com.example.movieapp.WebServices.MoviesViewModel;

import java.util.List;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;


public class MovieDetails extends AppCompatActivity {
    MoviesViewModel movieViewModel;
    RecyclerView rv_movie_Details_actors;
    ImageView tv_movie_Details_img;
    TextView tv_movie_Details_title, tv_movie_Details_ratecount, tv_movie_Details_rate, tv_movie_Details_type, tv_movie_Details_story;
    ActorsMoveAdapter actorsMoveAdapter;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        tv_movie_Details_img = findViewById(R.id.tv_movie_Details_img);
        tv_movie_Details_title = findViewById(R.id.tv_movie_Details_title);
        tv_movie_Details_ratecount = findViewById(R.id.tv_movie_Details_ratecount);
        tv_movie_Details_rate = findViewById(R.id.tv_movie_Details_rate);
        tv_movie_Details_type = findViewById(R.id.tv_movie_Details_type);
        tv_movie_Details_story = findViewById(R.id.tv_movie_Details_story);
        id = getIntent().getExtras().getInt("id");
        initViews();
        getLiveData();
    }

    private void initViews() {
        rv_movie_Details_actors = findViewById(R.id.rv_movie_Details_actors);
        initRecyclerView(rv_movie_Details_actors);
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
    }

    private void getLiveData() {
        movieViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        movieViewModel.getMovieDetails(id);
        observeMovieDetailsData();
        movieViewModel.getActorsMovie(id);
        observeActorsData();
    }

    private void observeMovieDetailsData() {
        movieViewModel.getMovieDetailsResponseMutableLiveData().observe(this, new Observer<MovieDetailsResponse>() {
            @Override
            public void onChanged(MovieDetailsResponse movieDetailsResponse) {
                Log.d("here","current : "+movieDetailsResponse.getTitle());
                fillData(movieDetailsResponse);
            }
        });

    }
    private void observeActorsData() {
        movieViewModel.getMovieDetailsResponseMutableLiveData().observe(this, new Observer<MovieDetailsResponse>() {
            @Override
            public void onChanged(MovieDetailsResponse movieDetailsResponse) {
                fillData(movieDetailsResponse);
            }
        });
        movieViewModel.getActorsMovieMutableLiveData().observe(this, new Observer<List<CastItem>>() {
            @Override
            public void onChanged(List<CastItem> castItems) {
                actorsMoveAdapter = new ActorsMoveAdapter(castItems,MovieDetails.this);
                rv_movie_Details_actors.setAdapter(actorsMoveAdapter);
            }
        });
    }

    void fillData(MovieDetailsResponse movieDetailsResponse) {

        tv_movie_Details_rate.setText(String.valueOf(movieDetailsResponse.getVoteAverage()));
        tv_movie_Details_title.setText(movieDetailsResponse.getTitle());
        tv_movie_Details_story.setText(movieDetailsResponse.getOverview());
        tv_movie_Details_ratecount.setText(String.valueOf(movieDetailsResponse.getVoteCount()));
        if (movieDetailsResponse.getGenres() != null) {
            String type = "";
            for (GenresItem item : movieDetailsResponse.getGenres())
                type += item.getName() + " ,";
            tv_movie_Details_type.setText(type);
        }
        Glide.with(this)
                .load(IMAGEBASEURL+movieDetailsResponse.getPosterPath())
                .into(tv_movie_Details_img);

    }
}
