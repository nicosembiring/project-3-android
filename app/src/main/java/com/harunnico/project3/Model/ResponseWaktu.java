package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseWaktu{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private DataWaktu data;

	@SerializedName("status")
	private String status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(DataWaktu data){
		this.data = data;
	}

	public DataWaktu getData(){
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
			"ResponseWaktu{" + 
			"pesan = '" + pesan + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}