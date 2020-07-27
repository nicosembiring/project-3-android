package com.harunnico.project3.rest;

import com.harunnico.project3.Model.ResponseBarang;
import com.harunnico.project3.Model.ResponseGantiSupir;
import com.harunnico.project3.Model.ResponsePengemudi;
import com.harunnico.project3.Model.ResponseTujuan;
import com.harunnico.project3.Model.ResponseUser;
import com.harunnico.project3.Model.ResponseWaktu;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("user")
    Call<ResponseUser> loginRequest(@Field("username") String email,
                                    @Field("password") String password);

    @FormUrlEncoded
    @PUT("waktu_ambil")
    Call<ResponseWaktu> putWaktu(@Field("id_barang_keluar") String id_barang_keluar);

    @GET("barang")
    Call<ResponseBarang> getBarang(@Query("id_barang_keluar") String id_barang_keluar);

    @FormUrlEncoded
    @PUT("barang")
    Call<ResponseBarang>  putBarang(@Field("id_barang_keluar") String id_barang_keluar,
                                    @Field("id_pengemudi") String id_pengemudi,
                                    @Field("id_kendaraan") String id_kendaraan,
                                    @Field("token") String token);

    @GET("supir")
    Call<ResponsePengemudi> getPegemudi(@Query("id_pengemudi") String id_pengemudi);

    @FormUrlEncoded
    @PUT("supir")
    Call<ResponsePengemudi> putPengemudi(@Field("id_pengguna") String id_pengguna,
                                         @Field("nama") String nama,
                                         @Field("umur") String umur,
                                         @Field("alamat_pengguna") String alamat,
                                         @Field("no_hp_pengemudi") String no_hp_pengemudi,
                                         @Field("tgllahir") String tgllahir);

    @FormUrlEncoded
    @PUT("Gantisupir")
    Call<ResponseGantiSupir> putPenganti(@Field("id_pengemudi") String id_penggemudi,
                                         @Field("id_barang_keluar") String id_barang_keluar);

    @GET("tujuan")
    Call<ResponseTujuan> getTujuan(@Query("id_pengemudi") String id_pengemudi);
}
