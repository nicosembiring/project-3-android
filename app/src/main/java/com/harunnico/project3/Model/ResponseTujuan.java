package com.harunnico.project3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTujuan {
    @SerializedName("status")
    private String status;
    @SerializedName("pesan")
    private String pesan;
    @SerializedName("data")
    private List<Tujuan> data;

    public ResponseTujuan(String status, String pesan, List<Tujuan> data) {
        this.status = status;
        this.pesan = pesan;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getPesan() {
        return pesan;
    }

    public List<Tujuan> getData() {
        return data;
    }
}
