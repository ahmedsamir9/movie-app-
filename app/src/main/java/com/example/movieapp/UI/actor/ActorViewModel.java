package com.example.movieapp.UI.actor;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.Models.ActorDetailsResponse;
import com.example.movieapp.Models.ActorMovieCreditsResponse;
import com.example.movieapp.Models.CrewItem;
import com.example.movieapp.Models.CrewItemMoviee;
import com.example.movieapp.Models.ResultsActorItem;
import com.example.movieapp.Models.SearchActorsResponse;
import com.example.movieapp.WebServices.ApiManger;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.movieapp.Utiles.CONTANTS.APIKEY;
import static com.example.movieapp.Utiles.CONTANTS.LANGUAGE;

public class ActorViewModel extends AndroidViewModel {
    public ActorViewModel(@NonNull Application application) {
        super(application);
    }
    MutableLiveData<ActorDetailsResponse>actorData = new MutableLiveData<>();
    MutableLiveData<List<CrewItemMoviee>>actorMovies = new MutableLiveData<>();

    public MutableLiveData<List<ResultsActorItem>> getSearchActorsLiveData() {
        return searchActorsLiveData;
    }

    MutableLiveData<List<ResultsActorItem>> searchActorsLiveData=new MutableLiveData<>();


    public void getActorData(int id){
        Single<ActorDetailsResponse> observable = ApiManger.getApis().GetActorsDetails(id,APIKEY,LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->actorData.setValue(o),e-> Log.d("MoviesViewModel","here :"+e));
    }
    public void getActorCredits(int id){
        Single<ActorMovieCreditsResponse> observable = ApiManger.getApis().GetMoviesOfActors(id,APIKEY,LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->actorMovies.setValue(o.getCrew()),e-> Log.d("MoviesViewModel","here :"+e));
    }

    public void getSearchActors(String s){
        Single<SearchActorsResponse> observable = ApiManger.getApis().GetSearchActors(APIKEY,LANGUAGE,s,1,false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> searchActorsLiveData.setValue(o.getResults()), e-> Log.d("MoviesDetailsViewModel","here :"+e));
    }
}
