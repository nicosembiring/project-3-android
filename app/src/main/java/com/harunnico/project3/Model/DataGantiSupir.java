package com.harunnico.project3.Model;


import com.google.gson.annotations.SerializedName;


public class DataGantiSupir {

	@SerializedName("id_barang_keluar")
	private String idBarangKeluar;

	@SerializedName("id_pengemudi")
	private String idPengemudi;

	public void setIdBarangKeluar(String idBarangKeluar){
		this.idBarangKeluar = idBarangKeluar;
	}

	public String getIdBarangKeluar(){
		return idBarangKeluar;
	}

	public void setIdPengemudi(String idPengemudi){
		this.idPengemudi = idPengemudi;
	}

	public String getIdPengemudi(){
		return idPengemudi;
	}

	@Override
 	public String toString(){
		return 
			"DataGantiSupir{" +
			"id_barang_keluar = '" + idBarangKeluar + '\'' + 
			",id_pengemudi = '" + idPengemudi + '\'' + 
			"}";
		}
}