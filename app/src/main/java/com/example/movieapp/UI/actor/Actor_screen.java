package com.example.movieapp.UI.actor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Adapters.ActorsCreditsAdapter;
import com.example.movieapp.Models.ActorDetailsResponse;
import com.example.movieapp.Models.CrewItemMoviee;
import com.example.movieapp.R;
import com.example.movieapp.UI.Movie.MovieDetails;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

import static com.example.movieapp.Utiles.CONTANTS.IMAGEBASEURL;

public class Actor_screen extends AppCompatActivity {

    private ImageView actorImg;
    private TextView actorName;
    private TextView actorName2;
    private TextView bioStauts;
    private TextView dateStauts;
    private AVLoadingIndicatorView progressbar;
    private RecyclerView rvActorMovies;
    ActorViewModel model;
    int Actor_id = 0;
    ActorsCreditsAdapter actorsCreditsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_screen);

        Actor_id = getIntent().getExtras().getInt("A-id");
        ;
        initView();
        subscribeToLiveData();
        model.getActorData(Actor_id);
        model.getActorCredits(Actor_id);
    }

    @Override
    protected void onStart() {
        super.onStart();
        subscribeToLiveData();
    }

    private void RecyclerViewinti() {
        rvActorMovies = (RecyclerView) findViewById(R.id.rv_actor_movies);
        actorsCreditsAdapter = new ActorsCreditsAdapter(new ArrayList<>(), Actor_screen.this);
        rvActorMovies.setAdapter(actorsCreditsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
        rvActorMovies.setLayoutManager(gridLayoutManager);
        actorsCreditsAdapter.setOnClickmovie(new ActorsCreditsAdapter.OnClickLisnterr() {
            @Override
            public void onClickOnMovie(CrewItemMoviee movie) {
                Intent intent = new Intent(Actor_screen.this, MovieDetails.class);
                intent.putExtra("id", movie.getId());
                startActivity(intent);
            }
        });
    }

    private void initView() {

        actorImg = (ImageView) findViewById(R.id.actor_img);
        actorName = (TextView) findViewById(R.id.actorName);
        actorName2 = (TextView) findViewById(R.id.nameTwo);
        bioStauts = (TextView) findViewById(R.id.bio_stauts);
        dateStauts = (TextView) findViewById(R.id.date_stauts);
        progressbar = findViewById(R.id.progressbar);
        RecyclerViewinti();
        model = new ViewModelProvider(this).get(ActorViewModel.class);
    }


    private void subscribeToLiveData() {
        model.actorData.observe(this, new Observer<ActorDetailsResponse>() {
            @Override
            public void onChanged(ActorDetailsResponse actorDetailsResponse) {
                if (actorDetailsResponse.getProfilePath() != null)
                    Glide.with(Actor_screen.this)
                            .load(IMAGEBASEURL + actorDetailsResponse.getProfilePath())
                            .into(actorImg);
                else
                    actorImg.setImageDrawable(getResources().getDrawable(R.drawable.actor));

                actorName.setText(actorDetailsResponse.getName());
                actorName2.setText(actorDetailsResponse.getName());
                bioStauts.setText(actorDetailsResponse.getBiography());
                dateStauts.setText(actorDetailsResponse.getBirthday());
                progressbar.hide();
            }
        });
        model.actorMovies.observe(this, crewItemMoviees -> actorsCreditsAdapter.onChange(crewItemMoviees));

    }
}
