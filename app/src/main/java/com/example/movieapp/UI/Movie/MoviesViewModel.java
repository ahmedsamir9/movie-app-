package com.example.movieapp.UI.Movie;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.Models.CastItem;
import com.example.movieapp.Models.MovieCrewResponse;
import com.example.movieapp.Models.MovieDetailsResponse;
import com.example.movieapp.Models.MoviesResponse;
import com.example.movieapp.Models.ResultSearchItem;
import com.example.movieapp.Models.ResultsActorItem;
import com.example.movieapp.Models.ResultsMovieItem;
import com.example.movieapp.Models.SearchActorsResponse;
import com.example.movieapp.Models.SearchMovieResponse;
import com.example.movieapp.Models.SearchResponse;
import com.example.movieapp.WebServices.ApiManger;

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
    private MutableLiveData<List<ResultsMovieItem>> upComingMoviesMutableLiveData=new MutableLiveData<>();
    private MutableLiveData <MovieDetailsResponse> movieDetailsResponseMutableLiveData=new MutableLiveData<>();
    private MutableLiveData<List<CastItem>> actorsMovieMutableLiveData=new MutableLiveData<>();
    private MutableLiveData<List<ResultsMovieItem>> searchMoviesLiveData=new MutableLiveData<>();
    public MutableLiveData<List<ResultsMovieItem>> getSearchMoviesLiveData() {
        return searchMoviesLiveData;
    }

    public void setSearchMoviesLiveData(MutableLiveData<List<ResultsMovieItem>> searchMoviesLiveData) {
        this.searchMoviesLiveData = searchMoviesLiveData;
    }





    public MutableLiveData<List<CastItem>> getActorsMovieMutableLiveData() {
        return actorsMovieMutableLiveData;
    }

    public void setActorsMovieMutableLiveData(MutableLiveData<List<CastItem>> actorsMovieMutableLiveData) {
        this.actorsMovieMutableLiveData = actorsMovieMutableLiveData;
    }
    public MutableLiveData<MovieDetailsResponse> getMovieDetailsResponseMutableLiveData() {
        return movieDetailsResponseMutableLiveData;
    }

    public void setMovieDetailsResponseMutableLiveData(MutableLiveData<MovieDetailsResponse> movieDetailsResponseMutableLiveData) {
        this.movieDetailsResponseMutableLiveData = movieDetailsResponseMutableLiveData;
    }

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

    public void getMovieDetails(int index){
        Single<MovieDetailsResponse> observable = ApiManger.getApis().GetMovieDetails(index,APIKEY,LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> movieDetailsResponseMutableLiveData.setValue(o), e-> Log.d("MoviesDetailsViewModel","here :"+e));

    }

    public void getActorsMovie(int index){
        Single<MovieCrewResponse> observable = ApiManger.getApis().GetMovieCast(index,APIKEY,LANGUAGE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> actorsMovieMutableLiveData.setValue(o.getCast()), e-> Log.d("MoviesDetailsViewModel","here :"+e));
    }

    public void getSearchMovies(String s){
        Single<SearchMovieResponse> observable = ApiManger.getApis().GetSearchMovies(APIKEY,LANGUAGE,s,1,false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(o-> searchMoviesLiveData.setValue(o.getResults()), e-> Log.d("MoviesDetailsViewModel","here :"+e));
    }
}
