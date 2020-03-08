package com.example.movieapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActorDetailsResponse{

	@SerializedName("birthday")
	private String birthday;

	@SerializedName("also_known_as")
	private List<String> alsoKnownAs;

	@SerializedName("gender")
	private int gender;

	@SerializedName("imdb_id")
	private String imdbId;

	@SerializedName("known_for_department")
	private String knownForDepartment;

	@SerializedName("profile_path")
	private String profilePath;

	@SerializedName("biography")
	private String biography;

	@SerializedName("deathday")
	private Object deathday;

	@SerializedName("place_of_birth")
	private String placeOfBirth;

	@SerializedName("popularity")
	private double popularity;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("adult")
	private boolean adult;

	@SerializedName("homepage")
	private Object homepage;

	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	public String getBirthday(){
		return birthday;
	}

	public void setAlsoKnownAs(List<String> alsoKnownAs){
		this.alsoKnownAs = alsoKnownAs;
	}

	public List<String> getAlsoKnownAs(){
		return alsoKnownAs;
	}

	public void setGender(int gender){
		this.gender = gender;
	}

	public int getGender(){
		return gender;
	}

	public void setImdbId(String imdbId){
		this.imdbId = imdbId;
	}

	public String getImdbId(){
		return imdbId;
	}

	public void setKnownForDepartment(String knownForDepartment){
		this.knownForDepartment = knownForDepartment;
	}

	public String getKnownForDepartment(){
		return knownForDepartment;
	}

	public void setProfilePath(String profilePath){
		this.profilePath = profilePath;
	}

	public String getProfilePath(){
		return profilePath;
	}

	public void setBiography(String biography){
		this.biography = biography;
	}

	public String getBiography(){
		return biography;
	}

	public void setDeathday(Object deathday){
		this.deathday = deathday;
	}

	public Object getDeathday(){
		return deathday;
	}

	public void setPlaceOfBirth(String placeOfBirth){
		this.placeOfBirth = placeOfBirth;
	}

	public String getPlaceOfBirth(){
		return placeOfBirth;
	}

	public void setPopularity(double popularity){
		this.popularity = popularity;
	}

	public double getPopularity(){
		return popularity;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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

	public void setHomepage(Object homepage){
		this.homepage = homepage;
	}

	public Object getHomepage(){
		return homepage;
	}

	@Override
 	public String toString(){
		return 
			"ActorDetailsResponse{" + 
			"birthday = '" + birthday + '\'' + 
			",also_known_as = '" + alsoKnownAs + '\'' + 
			",gender = '" + gender + '\'' + 
			",imdb_id = '" + imdbId + '\'' + 
			",known_for_department = '" + knownForDepartment + '\'' + 
			",profile_path = '" + profilePath + '\'' + 
			",biography = '" + biography + '\'' + 
			",deathday = '" + deathday + '\'' + 
			",place_of_birth = '" + placeOfBirth + '\'' + 
			",popularity = '" + popularity + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",adult = '" + adult + '\'' + 
			",homepage = '" + homepage + '\'' + 
			"}";
		}
}