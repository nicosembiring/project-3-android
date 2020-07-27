package com.harunnico.project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.harunnico.project3.Model.DataPengemudi;
import com.harunnico.project3.Model.ResponsePengemudi;
import com.harunnico.project3.rest.ApiService;
import com.harunnico.project3.rest.UtilsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    ImageView imageViewPengemudi;
    TextView textView_nama;
    TextView textView_umur;
    TextView textView_lahir;
    TextView textView_notel;
    TextView textView_alamat;
    TextView textView_id_pengguna;
    Button button_editprofil;

    ApiService mApiService;

    //String id_pengguna="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        mApiService = UtilsApi.getAPIService();

        imageViewPengemudi = (ImageView) findViewById(R.id.imageViewPengemudi);
        textView_id_pengguna = (TextView) findViewById(R.id.textView_id_pengguna);
        textView_nama = (TextView) findViewById(R.id.textView_nama);
        textView_umur = (TextView) findViewById(R.id.textView_umur);
        textView_lahir = (TextView) findViewById(R.id.textView_lahir);
        textView_notel = (TextView) findViewById(R.id.textView_notel);
        textView_alamat = (TextView) findViewById(R.id.textView_alamat);
        button_editprofil = (Button) findViewById(R.id.button_editprofil);

        setProfile();
    }

    private void setProfile(){

        mApiService.getPegemudi("DRV001").enqueue(new Callback<ResponsePengemudi>() {
            @Override
            public void onResponse(Call<ResponsePengemudi> call, Response<ResponsePengemudi> response) {

                List<DataPengemudi> pengemudi = response.body().getData();

                textView_id_pengguna.setText(pengemudi.get(0).getIdPengguna());
                textView_nama.setText(pengemudi.get(0).getNama());
                textView_umur.setText(pengemudi.get(0).getUmur());
                textView_lahir.setText(pengemudi.get(0).getTanggalLahir());
                textView_notel.setText(pengemudi.get(0).getNoHpPengemudi());
                textView_alamat.setText(pengemudi.get(0).getAlamatPengguna());
                //id_pengguna=pengemudi.get(0).getIdPengguna();

            }

            @Override
            public void onFailure(Call<ResponsePengemudi> call, Throwable t) {

            }
        });
    }

    public void edit_profil(View view) {
        Intent intent = new Intent(this,EditActivity.class);
        intent.putExtra("id_pengguna",textView_id_pengguna.getText());
        intent.putExtra("nama", textView_nama.getText());
        intent.putExtra("umur", textView_umur.getText());
        intent.putExtra("lahir", textView_lahir.getText());
        intent.putExtra("telepon", textView_notel.getText());
        intent.putExtra("alamat",textView_alamat.getText());
        //intent.putExtra("id_pengguna", id_pengguna);
        startActivity(intent);
    }
}
