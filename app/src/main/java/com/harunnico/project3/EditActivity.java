package com.harunnico.project3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.harunnico.project3.Model.ResponsePengemudi;
import com.harunnico.project3.rest.ApiService;
import com.harunnico.project3.rest.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {

    EditText nama,umur,lahir,notel,alamat;
    TextView id_pengguna;
    Button btn_simpan;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit);

        mApiService = UtilsApi.getAPIService();
        nama = (EditText) findViewById(R.id.editText_nama);
        umur = (EditText) findViewById(R.id.editText_umur);
        lahir = (EditText) findViewById(R.id.editText_lahir);
        notel = (EditText) findViewById(R.id.editText_notel);
        alamat = (EditText) findViewById(R.id.editText_alamat);
        id_pengguna = (TextView) findViewById(R.id.textView_id_pengguna);
        btn_simpan = findViewById(R.id.button_simpan);
        nama.setText(getIntent().getStringExtra("nama"));
        umur.setText(getIntent().getStringExtra("umur"));
        lahir.setText(getIntent().getStringExtra("lahir"));
        notel.setText(getIntent().getStringExtra("telepon"));
        alamat.setText(getIntent().getStringExtra("alamat"));
        id_pengguna.setText(getIntent().getStringExtra("id_pengguna"));
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
        });



    }

    public void simpan() {
        String idpengguna = id_pengguna.getText().toString();
        String namasupir = nama.getText().toString();
        String umursupir = umur.getText().toString();
        String lahirsupir = lahir.getText().toString();
        String notelsupir = notel.getText().toString();
        String alamatsupir = alamat.getText().toString();



        mApiService.putPengemudi(idpengguna, namasupir, umursupir, alamatsupir, notelsupir, lahirsupir).enqueue(new Callback<ResponsePengemudi>() {
            @Override
            public void onResponse(Call<ResponsePengemudi> call, Response<ResponsePengemudi> response) {

                //Log.d("lala", String.valueOf());
                if(response.body().getStatus().equals("true")){
                    startActivity(new Intent(getApplicationContext(), UserActivity.class));
                    finish();
                    Toast.makeText(getApplicationContext(), "Ubah", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Jgn coba", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponsePengemudi> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
            }
        });
        Intent intent = new Intent(this,UserActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(getApplicationContext(),"DataUser Berhasil Diubah",Toast.LENGTH_SHORT).show();
    }
}
