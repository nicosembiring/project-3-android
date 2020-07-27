package com.harunnico.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.harunnico.project3.Model.DataBarang;
import com.harunnico.project3.Model.ResponseBarang;
import com.harunnico.project3.rest.ApiService;
import com.harunnico.project3.rest.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmActivity extends AppCompatActivity {
    private TextView idbk,idpeng,idken;
    private EditText tkn;
    private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        mApiService = UtilsApi.getAPIService();
        idbk = (TextView) findViewById(R.id.textView_idbk);
        idpeng = (TextView) findViewById(R.id.textView_idpeng);
        idken = (TextView) findViewById(R.id.textView_idken);
        dataID();
        tkn = (EditText) findViewById(R.id.editText_token);
    }

    private void dataID() {
        mApiService.getBarang("ITOU001").enqueue(new Callback<ResponseBarang>() {
            @Override
            public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
                List<DataBarang> barang = response.body().getData();
                idbk.setText(barang.get(0).getIdBarangKeluar());
                idpeng.setText(barang.get(0).getIdPengemudi());
                idken.setText(barang.get(0).getIdKendaraan());
            }

            @Override
            public void onFailure(Call<ResponseBarang> call, Throwable t) {

            }
        });
    }

    public void selesai(View view) {
        String id_barang_keluar = idbk.getText().toString();
        String id_pengemudi = idpeng.getText().toString();
        String id_kendaraan = idken.getText().toString();
        String token = tkn.getText().toString();

        mApiService.putBarang(id_barang_keluar,id_pengemudi,id_kendaraan,token).enqueue(new Callback<ResponseBarang>() {
            @Override
            public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
                if(response.body().getStatus().equals("true")){
                    startActivity(new Intent(getApplicationContext(), DataActivity.class));
                    finish();
                    Toast.makeText(getApplicationContext(), "Pengiriman Selesai", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Token Salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBarang> call, Throwable t) {

            }
        });
        Intent intent = new Intent(this,DataActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(getApplicationContext(), "Pengiriman Selesai", Toast.LENGTH_SHORT).show();
    }
}
