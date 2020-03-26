package com.example.movieapp.UI.actor;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.Models.ActorDetailsResponse;
import com.example.movieapp.Models.ActorMoviesResposns;
import com.example.movieapp.Models.CrewItemMoviee;
import com.example.movieapp.WebServices.ApiManger;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.movieapp.Utiles.CONTANTS.APIKEY;
import static com.example.movieapp.Utiles.CONTANTS.LANGUAGE;

public class actorViewModel extends AndroidViewModel {
    public actorViewModel(@NonNull Application application) {
        super(application);
    }
    MutableLiveData<ActorDetailsResponse>actorData = new MutableLiveData<>();
    MutableLiveData<List<CrewItemMoviee>>actorMovies = new MutableLiveData<>();


    public void getActorData(int id){
        Single<ActorDetailsResponse> observable = ApiManger.getApis().GetActorsDetails(id,APIKEY,LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->actorData.setValue(o),e-> Log.d("MoviesViewModel","here :"+e));
       // progress.setValue(true);
    }
    public void getActorCredits(int id){
        Single<ActorMoviesResposns> observable = ApiManger.getApis().GetMoviesOfActors(id,APIKEY,LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->actorMovies.setValue(o.getCrew()),e-> Log.d("MoviesViewModel","here :"+e));
    }

}
