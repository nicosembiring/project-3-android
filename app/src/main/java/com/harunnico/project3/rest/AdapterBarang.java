package com.harunnico.project3.rest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.harunnico.project3.DetailActivity;
import com.harunnico.project3.Model.DataBarang;
import com.harunnico.project3.R;

import java.util.List;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.MyViewHolder>{
    private List<DataBarang> contacts;
    private Context context;

    public AdapterBarang(List contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(contacts.get(position).getNamaMerkBarang());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Kategori", contacts.get(position).getNamaKtgrBrg());
                intent.putExtra("Nama Barang", contacts.get(position).getNamaBarang());
                intent.putExtra("Merk Barang", contacts.get(position).getNamaMerkBarang());
                intent.putExtra("Jumlah Barang", contacts.get(position).getJmlhBrgKlr());


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,email;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvNamaBarang);
        }
    }
}