package com.harunnico.project3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.harunnico.project3.Model.DataBarang;
import com.harunnico.project3.Model.ResponseBarang;
import com.harunnico.project3.Model.ResponseWaktu;
import com.harunnico.project3.rest.AdapterBarang;
import com.harunnico.project3.rest.ApiService;
import com.harunnico.project3.rest.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<DataBarang> contacts;
    private AdapterBarang mAdapterBarang;
    private ApiService mApiService;
    private TextView idbk;


    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        mApiService = UtilsApi.getAPIService();
        idbk =  findViewById(R.id.textView_idbk);
        dataID();

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchContact("users");

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "Membutuhkan Izin Lokasi", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);
            }
        } else {
            // Permission has already been granted
            Toast.makeText(this, "Izin Lokasi diberikan", Toast.LENGTH_SHORT).show();
        }if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "Membutuhkan Izin Lokasi", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);
            }
        } else {
            // Permission has already been granted
            Toast.makeText(this, "Izin Lokasi diberikan", Toast.LENGTH_SHORT).show();
        }

    }

    private void dataID() {
        mApiService.getBarang("ITOU001").enqueue(new Callback<ResponseBarang>() {
            @Override
            public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
                List<DataBarang> barang = response.body().getData();
                idbk.setText(barang.get(0).getIdBarangKeluar());
            }

            @Override
            public void onFailure(Call<ResponseBarang> call, Throwable t) {

            }
        });
    }

    public void fetchContact(String type){
        mApiService.getBarang("ITOU001").enqueue(new Callback<ResponseBarang>() {
            @Override
            public void onResponse(Call<ResponseBarang> call, retrofit2.Response<ResponseBarang> response) {
                //response.body().getDataWaktu();
                contacts = response.body().getData();
                mAdapterBarang = new AdapterBarang(contacts, DataActivity.this);
                recyclerView.setAdapter(mAdapterBarang);
                mAdapterBarang.notifyDataSetChanged();
                Log.d("lala", String.valueOf(response.body().getPesan()));
            }

            @Override
            public void onFailure(Call<ResponseBarang> call, Throwable t) {

            }
        });

    }

    public void map(View view) {
        String id_barang_keluar = idbk.getText().toString();
        System.out.println(id_barang_keluar+"lala");
        mApiService.putWaktu(id_barang_keluar).enqueue(new Callback<ResponseWaktu>() {
            @Override
            public void onResponse(Call<ResponseWaktu> call, Response<ResponseWaktu> response) {
                if(response.body().getStatus().equals("true")){
                    //startActivity(new Intent(getApplicationContext(), DirectionsActivity.class));
                    //finish();
                    Toast.makeText(getApplicationContext(), "Mulai Menghitung Waktu", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Jgn coba", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseWaktu> call, Throwable t) {

            }
        });
        Toast.makeText(getApplicationContext(), "Mulai Menghitung Waktu", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DirectionsActivity.class));
    }


    public void selesai(View view) {
        Intent intent = new Intent(this,ConfirmActivity.class);
        startActivity(intent);
    }
}