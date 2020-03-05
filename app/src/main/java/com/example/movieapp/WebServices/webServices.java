package com.example.movieapp.WebServices;

import com.example.movieapp.Models.MovieCrewResponse;
import com.example.movieapp.Models.MovieDetailsResponse;
import com.example.movieapp.Models.MovieVideoResponse;
import com.example.movieapp.Models.MoviesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface webServices {
    @GET("movie/{movie_id}")
    Single<MovieDetailsResponse> GetMovieDetails(@Query("api_key")String apikey , @Query("language")String language);
    @GET("movie/{movie_id}/videos")
    Single<MovieVideoResponse> GetMovieVides(@Query("api_key")String apikey , @Query("language")String language);
    @GET("movie/{movie_id}/credits")
    Single<MovieCrewResponse> GetMovieCast(@Query("api_key")String apikey , @Query("language")String language);
    @GET("movie/top_rated")
    Single<MoviesResponse> GetTopRatedMovies(@Query("api_key")String apikey , @Query("language")String language,@Query("page")int page);
    @GET("movie/popular")
    Single<MoviesResponse> GetPopularMovies(@Query("api_key")String apikey , @Query("language")String language,@Query("page")int page);
    @GET("movie/now_playing")
    Single<MoviesResponse> GetPlayingNowMovies(@Query("api_key")String apikey , @Query("language")String language,@Query("page")int page);
    @GET("movie/upcoming")
    Single<MoviesResponse> GetUpComingMovies(@Query("api_key")String apikey , @Query("language")String language,@Query("page")int page);

}
