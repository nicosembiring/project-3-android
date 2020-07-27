package com.harunnico.project3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tujuan {
    @SerializedName("id_barang_keluar")
    private String idBarangKeluar;
    @SerializedName("id_pengemudi")
    private String idPengemudi;
    @SerializedName("id_kendaraan")
    private String idKendaraan;
    @SerializedName("id_tujuan")
    private String idTujuan;
    @SerializedName("nama_lokasi_tujuan")
    private String namaLokasiTujuan;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public Tujuan(String idBarangKeluar, String idPengemudi, String idKendaraan, String idTujuan, String namaLokasiTujuan, String latitude, String longitude) {
        this.idBarangKeluar = idBarangKeluar;
        this.idPengemudi = idPengemudi;
        this.idKendaraan = idKendaraan;
        this.idTujuan = idTujuan;
        this.namaLokasiTujuan = namaLokasiTujuan;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Tujuan(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
