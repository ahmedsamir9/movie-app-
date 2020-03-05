package com.example.movieapp.WebServices;

import com.example.movieapp.Utiles.CONTANTS;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManger {
    private static Retrofit retrofit;
    public static Retrofit getInstance(){

        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(CONTANTS.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static webServices getApis(){
        return getInstance().create(webServices.class);
    }
}
