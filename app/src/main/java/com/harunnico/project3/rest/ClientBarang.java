package com.harunnico.project3.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientBarang {
    public static final String BASE_URL = "http://192.168.43.188/Proyek3-API/index.php/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
