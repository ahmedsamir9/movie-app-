package com.example.movieapp.WebServices;

import com.example.movieapp.Models.MovieCrewResponse;
import com.example.movieapp.Models.MovieDetailsResponse;
import com.example.movieapp.Models.MovieVideoResponse;
import com.example.movieapp.Models.MoviesResponse;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface webServices {
    @GET("movie/{movie_id}")
    Single<MovieDetailsResponse> GetMovieDetails(@Path("movie_id")int movie_id, @Query("api_key")String apikey , @Query("language")String language);
    @GET("movie/{movie_id}/videos")
    Single<MovieVideoResponse> GetMovieVides(@Path("movie_id")int movie_id,@Query("api_key")String apikey , @Query("language")String language);
    @GET("movie/{movie_id}/credits")
    Single<MovieCrewResponse> GetMovieCast(@Path("movie_id")int movie_id,@Query("api_key")String apikey , @Query("language")String language);
    @GET("movie/top_rated")
    Single<MoviesResponse> GetTopRatedMovies(@Query("api_key")String apikey , @Query("language")String language,@Query("page")int page);
    @GET("movie/popular")
    Single<MoviesResponse> GetPopularMovies(@Query("api_key")String apikey , @Query("language")String language,@Query("page")int page);
    @GET("movie/now_playing")
    Single<MoviesResponse> GetPlayingNowMovies(@Query("api_key")String apikey , @Query("language")String language,@Query("page")int page);
    @GET("movie/upcoming")
    Single<MoviesResponse> GetUpComingMovies(@Query("api_key")String apikey , @Query("language")String language,@Query("page")int page);
    @GET("search/multi")
    Single<MoviesResponse> GetMultiSearch(@Query("api_key")String apikey , @Query("language")String language,@Query("query")String query,@Query("page")int page,@Query("include_adult")boolean include_adult);
    @GET("person/{person_id}")
    Single<MoviesResponse> GetActorsDetails(@Path("movie_id")String movie_id,@Query("api_key")String apikey , @Query("language")String language);
    @GET("person/{person_id}/movie_credits")
    Single<MoviesResponse> GetMoviesOfActors(@Path("movie_id")String movie_id,@Query("api_key")String apikey , @Query("language")String language);

}







