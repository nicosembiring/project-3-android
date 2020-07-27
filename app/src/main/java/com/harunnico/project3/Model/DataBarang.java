package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;

public class DataBarang {

    @SerializedName("dimensi_barang")
    private String dimensiBarang;

    @SerializedName("jmlh_brg_klr")
    private String jmlhBrgKlr;

    @SerializedName("nama_merk_barang")
    private String namaMerkBarang;

    @SerializedName("id_kendaraan")
    private String idKendaraan;

    @SerializedName("id_merk_barang")
    private String idMerkBarang;

    @SerializedName("id_barang_keluar")
    private String idBarangKeluar;

    @SerializedName("id_nama_barang")
    private String idNamaBarang;

    @SerializedName("id_pengemudi")
    private String idPengemudi;

    @SerializedName("id_barang")
    private String idBarang;

    @SerializedName("total_dimensi")
    private String totalDimensi;

    @SerializedName("nama_ktgr_brg")
    private String namaKtgrBrg;

    @SerializedName("id_ktgr_brg")
    private String idKtgrBrg;

    @SerializedName("nama_barang")
    private String namaBarang;

    public void setDimensiBarang(String dimensiBarang){
        this.dimensiBarang = dimensiBarang;
    }

    public String getDimensiBarang(){
        return dimensiBarang;
    }

    public void setJmlhBrgKlr(String jmlhBrgKlr){
        this.jmlhBrgKlr = jmlhBrgKlr;
    }

    public String getJmlhBrgKlr(){
        return jmlhBrgKlr;
    }

    public void setNamaMerkBarang(String namaMerkBarang){
        this.namaMerkBarang = namaMerkBarang;
    }

    public String getNamaMerkBarang(){
        return namaMerkBarang;
    }

    public void setIdKendaraan(String idKendaraan){
        this.idKendaraan = idKendaraan;
    }

    public String getIdKendaraan(){
        return idKendaraan;
    }

    public void setIdMerkBarang(String idMerkBarang){
        this.idMerkBarang = idMerkBarang;
    }

    public String getIdMerkBarang(){
        return idMerkBarang;
    }

    public void setIdBarangKeluar(String idBarangKeluar){
        this.idBarangKeluar = idBarangKeluar;
    }

    public String getIdBarangKeluar(){
        return idBarangKeluar;
    }

    public void setIdNamaBarang(String idNamaBarang){
        this.idNamaBarang = idNamaBarang;
    }

    public String getIdNamaBarang(){
        return idNamaBarang;
    }

    public void setIdPengemudi(String idPengemudi){
        this.idPengemudi = idPengemudi;
    }

    public String getIdPengemudi(){
        return idPengemudi;
    }

    public void setIdBarang(String idBarang){
        this.idBarang = idBarang;
    }

    public String getIdBarang(){
        return idBarang;
    }

    public void setTotalDimensi(String totalDimensi){
        this.totalDimensi = totalDimensi;
    }

    public String getTotalDimensi(){
        return totalDimensi;
    }

    public void setNamaKtgrBrg(String namaKtgrBrg){
        this.namaKtgrBrg = namaKtgrBrg;
    }

    public String getNamaKtgrBrg(){
        return namaKtgrBrg;
    }

    public void setIdKtgrBrg(String idKtgrBrg){
        this.idKtgrBrg = idKtgrBrg;
    }

    public String getIdKtgrBrg(){
        return idKtgrBrg;
    }

    public void setNamaBarang(String namaBarang){
        this.namaBarang = namaBarang;
    }

    public String getNamaBarang(){
        return namaBarang;
    }

    @Override
    public String toString(){
        return
                "DataBarang{" +
                        "dimensi_barang = '" + dimensiBarang + '\'' +
                        ",jmlh_brg_klr = '" + jmlhBrgKlr + '\'' +
                        ",nama_merk_barang = '" + namaMerkBarang + '\'' +
                        ",id_kendaraan = '" + idKendaraan + '\'' +
                        ",id_merk_barang = '" + idMerkBarang + '\'' +
                        ",id_barang_keluar = '" + idBarangKeluar + '\'' +
                        ",id_nama_barang = '" + idNamaBarang + '\'' +
                        ",id_pengemudi = '" + idPengemudi + '\'' +
                        ",id_barang = '" + idBarang + '\'' +
                        ",total_dimensi = '" + totalDimensi + '\'' +
                        ",nama_ktgr_brg = '" + namaKtgrBrg + '\'' +
                        ",id_ktgr_brg = '" + idKtgrBrg + '\'' +
                        ",nama_barang = '" + namaBarang + '\'' +
                        "}";
    }
}
