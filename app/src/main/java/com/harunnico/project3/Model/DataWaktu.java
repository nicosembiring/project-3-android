package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;

public class DataWaktu {

	@SerializedName("waktu_ambil")
	private String waktuAmbil;

	@SerializedName("id_barang_keluar")
	private String idBarangKeluar;

	public void setWaktuAmbil(String waktuAmbil){
		this.waktuAmbil = waktuAmbil;
	}

	public String getWaktuAmbil(){
		return waktuAmbil;
	}

	public void setIdBarangKeluar(String idBarangKeluar){
		this.idBarangKeluar = idBarangKeluar;
	}

	public String getIdBarangKeluar(){
		return idBarangKeluar;
	}

	@Override
 	public String toString(){
		return 
			"DataWaktu{" +
			"waktu_ambil = '" + waktuAmbil + '\'' + 
			",id_barang_keluar = '" + idBarangKeluar + '\'' + 
			"}";
		}
}