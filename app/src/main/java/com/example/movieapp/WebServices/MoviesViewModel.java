package com.example.movieapp.WebServices;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.Models.MoviesResponse;
import com.example.movieapp.Models.ResultsMovieItem;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.movieapp.Utiles.CONTANTS.APIKEY;
import static com.example.movieapp.Utiles.CONTANTS.LANGUAGE;

public class MoviesViewModel extends ViewModel {
    private MutableLiveData<List<ResultsMovieItem>> popularMoviesMutableLiveData=new MutableLiveData<>();
    private MutableLiveData<List<ResultsMovieItem>> playingNowMoviesMutableLiveData=new MutableLiveData<>();
    private MutableLiveData<List<ResultsMovieItem>> topRatedMoviesMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<List<ResultsMovieItem>> getPopularMoviesMutableLiveData() {
        return popularMoviesMutableLiveData;
    }

    public void setPopularMoviesMutableLiveData(MutableLiveData<List<ResultsMovieItem>> popularMoviesMutableLiveData) {
        this.popularMoviesMutableLiveData = popularMoviesMutableLiveData;
    }

    public MutableLiveData<List<ResultsMovieItem>> getPlayingNowMoviesMutableLiveData() {
        return playingNowMoviesMutableLiveData;
    }

    public void setPlayingNowMoviesMutableLiveData(MutableLiveData<List<ResultsMovieItem>> playingNowMoviesMutableLiveData) {
        this.playingNowMoviesMutableLiveData = playingNowMoviesMutableLiveData;
    }

    public MutableLiveData<List<ResultsMovieItem>> getTopRatedMoviesMutableLiveData() {
        return topRatedMoviesMutableLiveData;
    }

    public void setTopRatedMoviesMutableLiveData(MutableLiveData<List<ResultsMovieItem>> topRatedMoviesMutableLiveData) {
        this.topRatedMoviesMutableLiveData = topRatedMoviesMutableLiveData;
    }

    public MutableLiveData<List<ResultsMovieItem>> getUpComingMoviesMutableLiveData() {
        return upComingMoviesMutableLiveData;
    }

    public void setUpComingMoviesMutableLiveData(MutableLiveData<List<ResultsMovieItem>> upComingMoviesMutableLiveData) {
        this.upComingMoviesMutableLiveData = upComingMoviesMutableLiveData;
    }

    private MutableLiveData<List<ResultsMovieItem>> upComingMoviesMutableLiveData=new MutableLiveData<>();

    public void getPopularMovies(int index){
        Single<MoviesResponse> observable = ApiManger.getApis().GetPopularMovies(APIKEY,LANGUAGE,index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
       observable.subscribe(o->popularMoviesMutableLiveData.setValue(o.getResults()),e-> Log.d("MoviesViewModel","here :"+e));
    }
    public void getPlayingNowMovies(int index){
        Single<MoviesResponse> observable = ApiManger.getApis().GetPlayingNowMovies(APIKEY,LANGUAGE,index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->playingNowMoviesMutableLiveData.setValue(o.getResults()),e-> Log.d("MoviesViewModel","here :"+e));
    }
    public void getUpComingMovies(int index){
        Single<MoviesResponse> observable = ApiManger.getApis().GetUpComingMovies(APIKEY,LANGUAGE,index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->upComingMoviesMutableLiveData.setValue(o.getResults()),e-> Log.d("MoviesViewModel","here :"+e));
    }
    public void getTopRatedMovies(int index){
        Single<MoviesResponse> observable = ApiManger.getApis().GetTopRatedMovies(APIKEY,LANGUAGE,index)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o->topRatedMoviesMutableLiveData.setValue(o.getResults()),e-> Log.d("MoviesViewModel","here :"+e));
    }

}
