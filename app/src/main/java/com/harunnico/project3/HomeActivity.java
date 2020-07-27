package com.harunnico.project3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {

            finish();

            startActivity(new Intent(this, MainActivity.class));

        }
    }

    public void logout(View view) {

        SharedPrefManager.getInstance(this).logout();

        finish();

        startActivity(new Intent(this, MainActivity.class));

    }

    public void barang(View view) {
        startActivity(new Intent(this, DataActivity.class));
    }

    public void pengemudi(View view) {
        startActivity(new Intent(this, UserActivity.class));
    }

    public void tolaktugas(View view) { startActivity(new Intent(this, GantiActivity.class));
    }
}
