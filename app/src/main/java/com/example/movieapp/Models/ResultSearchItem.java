package com.example.movieapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultSearchItem {

	@SerializedName("media_type")
	private String mediaType;

	@SerializedName("known_for")
	private List<KnownForItem> knownFor;

	@SerializedName("popularity")
	private int popularity;

	@SerializedName("name")
	private String name;

	@SerializedName("profile_path")
	private String profilePath;

	@SerializedName("id")
	private int id;

	@SerializedName("adult")
	private boolean adult;

	@SerializedName("overview")
	private String overview;

	@SerializedName("original_language")
	private String originalLanguage;

	@SerializedName("original_title")
	private String originalTitle;

	@SerializedName("video")
	private boolean video;

	@SerializedName("title")
	private String title;

	@SerializedName("genre_ids")
	private List<Object> genreIds;

	@SerializedName("poster_path")
	private Object posterPath;

	@SerializedName("backdrop_path")
	private Object backdropPath;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("vote_average")
	private int voteAverage;

	@SerializedName("vote_count")
	private int voteCount;

	@SerializedName("first_air_date")
	private String firstAirDate;

	@SerializedName("origin_country")
	private List<String> originCountry;

	@SerializedName("original_name")
	private String originalName;

	public void setMediaType(String mediaType){
		this.mediaType = mediaType;
	}

	public String getMediaType(){
		return mediaType;
	}

	public void setKnownFor(List<KnownForItem> knownFor){
		this.knownFor = knownFor;
	}

	public List<KnownForItem> getKnownFor(){
		return knownFor;
	}

	public void setPopularity(int popularity){
		this.popularity = popularity;
	}

	public int getPopularity(){
		return popularity;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProfilePath(String profilePath){
		this.profilePath = profilePath;
	}

	public String getProfilePath(){
		return profilePath;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAdult(boolean adult){
		this.adult = adult;
	}

	public boolean isAdult(){
		return adult;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setOriginalLanguage(String originalLanguage){
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalLanguage(){
		return originalLanguage;
	}

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public void setVideo(boolean video){
		this.video = video;
	}

	public boolean isVideo(){
		return video;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setGenreIds(List<Object> genreIds){
		this.genreIds = genreIds;
	}

	public List<Object> getGenreIds(){
		return genreIds;
	}

	public void setPosterPath(Object posterPath){
		this.posterPath = posterPath;
	}

	public Object getPosterPath(){
		return posterPath;
	}

	public void setBackdropPath(Object backdropPath){
		this.backdropPath = backdropPath;
	}

	public Object getBackdropPath(){
		return backdropPath;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setVoteAverage(int voteAverage){
		this.voteAverage = voteAverage;
	}

	public int getVoteAverage(){
		return voteAverage;
	}

	public void setVoteCount(int voteCount){
		this.voteCount = voteCount;
	}

	public int getVoteCount(){
		return voteCount;
	}

	public void setFirstAirDate(String firstAirDate){
		this.firstAirDate = firstAirDate;
	}

	public String getFirstAirDate(){
		return firstAirDate;
	}

	public void setOriginCountry(List<String> originCountry){
		this.originCountry = originCountry;
	}

	public List<String> getOriginCountry(){
		return originCountry;
	}

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"media_type = '" + mediaType + '\'' + 
			",known_for = '" + knownFor + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",name = '" + name + '\'' + 
			",profile_path = '" + profilePath + '\'' + 
			",id = '" + id + '\'' + 
			",adult = '" + adult + '\'' + 
			",overview = '" + overview + '\'' + 
			",original_language = '" + originalLanguage + '\'' + 
			",original_title = '" + originalTitle + '\'' + 
			",video = '" + video + '\'' + 
			",title = '" + title + '\'' + 
			",genre_ids = '" + genreIds + '\'' + 
			",poster_path = '" + posterPath + '\'' + 
			",backdrop_path = '" + backdropPath + '\'' + 
			",release_date = '" + releaseDate + '\'' + 
			",vote_average = '" + voteAverage + '\'' + 
			",vote_count = '" + voteCount + '\'' + 
			",first_air_date = '" + firstAirDate + '\'' + 
			",origin_country = '" + originCountry + '\'' + 
			",original_name = '" + originalName + '\'' + 
			"}";
		}
}