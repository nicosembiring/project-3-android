package com.harunnico.project3.Model;

import com.google.gson.annotations.SerializedName;
public class DataUser {

    @SerializedName("id_pengguna")
    private String idPengguna;

    @SerializedName("nama")
    private String nama;

    @SerializedName("hak_akses")
    private String hakAkses;

    @SerializedName("username")
    private String username;

    public DataUser(String idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getIdPengguna() {
        return idPengguna;
    }

    public String getNama(){
        return nama;
    }

    public String getHakAkses(){
        return hakAkses;
    }

    public String getUsername(){
        return username;
    }
}
