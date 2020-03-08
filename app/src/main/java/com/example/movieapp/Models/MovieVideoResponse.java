package com.example.movieapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MovieVideoResponse{

	@SerializedName("id")
	private int id;

	@SerializedName("results")
	private List<ResultsVideoItem> results;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setResults(List<ResultsVideoItem> results){
		this.results = results;
	}

	public List<ResultsVideoItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"MovieVideoResponse{" + 
			"id = '" + id + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}