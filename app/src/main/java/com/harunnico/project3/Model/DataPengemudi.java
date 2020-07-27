package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;

public class DataPengemudi {
    @SerializedName("id_pengguna")
    private String idPengguna;
    @SerializedName("nama")
    private String nama;
    @SerializedName("umur")
    private String umur;
    @SerializedName("alamat_pengguna")
    private String alamatPengguna;
    @SerializedName("id_pengemudi")
    private String idPengemudi;
    @SerializedName("tanggal_lahir")
    private String tanggalLahir;
    @SerializedName("no_hp_penggemudi")
    private String noHpPengemudi;
    @SerializedName("foto_pengemudi")
    private String fotoPengemudi;
    @SerializedName("status_pengemudi")
    private String statusPengemudi;

    public String getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(String idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getAlamatPengguna() {
        return alamatPengguna;
    }

    public void setAlamatPengguna(String alamatPengguna) {
        this.alamatPengguna = alamatPengguna;
    }

    public String getIdPengemudi() {
        return idPengemudi;
    }

    public void setIdPengemudi(String idPengemudi) {
        this.idPengemudi = idPengemudi;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getNoHpPengemudi() {
        return noHpPengemudi;
    }

    public void setNoHpPengemudi(String noHpPengemudi) {
        this.noHpPengemudi = noHpPengemudi;
    }

    public String getFotoPengemudi() {
        return fotoPengemudi;
    }

    public void setFotoPengemudi(String fotoPengemudi) {
        this.fotoPengemudi = fotoPengemudi;
    }

    public String getStatusPengemudi() {
        return statusPengemudi;
    }

    public void setStatusPengemudi(String statusPengemudi) {
        this.statusPengemudi = statusPengemudi;
    }
}

