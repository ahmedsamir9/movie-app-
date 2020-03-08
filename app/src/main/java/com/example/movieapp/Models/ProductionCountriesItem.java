package com.example.movieapp.Models;

public class ProductionCountriesItem{
	private String iso31661;
	private String name;

	public void setIso31661(String iso31661){
		this.iso31661 = iso31661;
	}

	public String getIso31661(){
		return iso31661;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"ProductionCountriesItem{" + 
			"iso_3166_1 = '" + iso31661 + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}
