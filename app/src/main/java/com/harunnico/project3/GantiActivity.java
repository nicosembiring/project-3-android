package com.harunnico.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.harunnico.project3.Model.DataBarang;
import com.harunnico.project3.Model.ResponseBarang;
import com.harunnico.project3.Model.ResponseGantiSupir;
import com.harunnico.project3.rest.ApiService;
import com.harunnico.project3.rest.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GantiActivity extends AppCompatActivity {
    private TextView idbk,idpeng;
    private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti);
        idbk = findViewById(R.id.textView_bk);
        idpeng = findViewById(R.id.textView_pengemudi);
        mApiService = UtilsApi.getAPIService();
        dataID();
    }

    private void dataID() {
        mApiService.getBarang("ITOU001").enqueue(new Callback<ResponseBarang>() {
            @Override
            public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
                List<DataBarang> barang = response.body().getData();
                idbk.setText(barang.get(0).getIdBarangKeluar());
                idpeng.setText(barang.get(0).getIdPengemudi());
            }

            @Override
            public void onFailure(Call<ResponseBarang> call, Throwable t) {

            }
        });
    }

    public void KirimAlasan(View view) {
        String id_barang_keluar = idbk.getText().toString();
        String id_pengemudi = idpeng.getText().toString();
        mApiService.putPenganti(id_pengemudi,id_barang_keluar).enqueue(new Callback<ResponseGantiSupir>() {
            @Override
            public void onResponse(Call<ResponseGantiSupir> call, Response<ResponseGantiSupir> response) {
                if(response.body().getStatus().equals("true")){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                    Toast.makeText(getApplicationContext(), "Supir Telah Berganti", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Lanjutkan Pengiriman", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseGantiSupir> call, Throwable t) {

            }
        });
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(getApplicationContext(), "Supir Telah Berganti", Toast.LENGTH_SHORT).show();
    }

}