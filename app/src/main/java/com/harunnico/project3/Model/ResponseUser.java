package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseUser{

    @SerializedName("data")
    private DataUser data;

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("sukses")
    private String sukses;

    public DataUser getData(){
        return data;
    }

    public String getPesan() {
        return pesan;
    }

    public String getSukses() {
        return sukses;
    }
}
