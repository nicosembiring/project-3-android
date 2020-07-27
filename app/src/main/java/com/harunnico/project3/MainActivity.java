package com.harunnico.project3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.harunnico.project3.rest.ApiService;
import com.harunnico.project3.Model.ResponseUser;
import com.harunnico.project3.rest.UtilsApi;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText editText_username;
    EditText editText_password;
    Button button_login;
    ProgressDialog loading;

    Context mContext;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponents();
    }

    private void initComponents() {
        editText_username = (EditText) findViewById(R.id.editText_username);
        editText_password = (EditText) findViewById(R.id.editText_password);
        button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        String username = editText_username.getText().toString();
        String password = editText_password.getText().toString();



        mApiService.loginRequest(username, password).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                loading.dismiss();

                //Log.d("lala", String.valueOf());
                if(response.body().getSukses().equals("true")){
                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(response.body().getData());
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Jgn coba", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
                loading.dismiss();
            }
        });
    }

}
