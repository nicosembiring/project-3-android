package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBarang {

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("data")
    private List<DataBarang> data;

    @SerializedName("status")
    private String status;

    public void setPesan(String pesan){
        this.pesan = pesan;
    }

    public String getPesan(){
        return pesan;
    }

    public void setData(List<DataBarang> data){
        this.data = data;
    }

    public List<DataBarang> getData(){
        return data;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return
                "ResponseBarang{" +
                        "pesan = '" + pesan + '\'' +
                        ",data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
