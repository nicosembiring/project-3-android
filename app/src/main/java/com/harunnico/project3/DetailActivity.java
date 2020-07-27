package com.harunnico.project3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView textView_kategori;
    TextView textView_namabarang;
    TextView textView_merkbarang;
    TextView textView_jumlahbarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //    imageViewPengemudi = (ImageView) findViewById(R.id.imageViewPengemudi);
        textView_kategori = (TextView) findViewById(R.id.textView_kategori);
        textView_namabarang = (TextView) findViewById(R.id.textView_namabarang);
        textView_merkbarang = (TextView) findViewById(R.id.textView_merkbarang);
        textView_jumlahbarang = (TextView) findViewById(R.id.textView_jumlahbarang);

        textView_kategori.setText(getIntent().getStringExtra("Kategori"));
        textView_namabarang.setText(getIntent().getStringExtra("Nama Barang"));
        textView_merkbarang.setText(getIntent().getStringExtra("Merk Barang"));
        textView_jumlahbarang.setText(getIntent().getStringExtra("Jumlah Barang"));

    }
}
