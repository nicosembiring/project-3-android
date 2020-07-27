package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResponsePengemudi{

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("data")
    private List<DataPengemudi> data;

    @SerializedName("status")
    private String status;

    public void setPesan(String pesan){
        this.pesan = pesan;
    }

    public String getPesan(){
        return pesan;
    }

    public void setData(List<DataPengemudi> data){
        this.data = data;
    }

    public List<DataPengemudi> getData(){
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
                "ResponsePengemudi{" +
                        "pesan = '" + pesan + '\'' +
                        ",data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
