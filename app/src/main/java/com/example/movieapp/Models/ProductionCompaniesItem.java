package com.example.movieapp.Models;

public class ProductionCompaniesItem{
	private Object logoPath;
	private String name;
	private int id;
	private String originCountry;

	public void setLogoPath(Object logoPath){
		this.logoPath = logoPath;
	}

	public Object getLogoPath(){
		return logoPath;
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

	public void setOriginCountry(String originCountry){
		this.originCountry = originCountry;
	}

	public String getOriginCountry(){
		return originCountry;
	}

	@Override
 	public String toString(){
		return 
			"ProductionCompaniesItem{" + 
			"logo_path = '" + logoPath + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",origin_country = '" + originCountry + '\'' + 
			"}";
		}
}
