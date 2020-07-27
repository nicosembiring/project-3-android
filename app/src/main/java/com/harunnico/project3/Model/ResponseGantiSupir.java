package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseGantiSupir{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("dataGantiSupir")
	private DataGantiSupir dataGantiSupir;

	@SerializedName("status")
	private String status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataGantiSupir(DataGantiSupir dataGantiSupir){
		this.dataGantiSupir = dataGantiSupir;
	}

	public DataGantiSupir getDataGantiSupir(){
		return dataGantiSupir;
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
			"ResponseGantiSupir{" + 
			"pesan = '" + pesan + '\'' + 
			",dataGantiSupir = '" + dataGantiSupir + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}