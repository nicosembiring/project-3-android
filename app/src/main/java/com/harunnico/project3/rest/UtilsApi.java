package com.harunnico.project3.rest;

public class UtilsApi {

    public static final String BASE_URL_API =
            "http://192.168.43.188/Proyek3-API/index.php/";


    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
}
