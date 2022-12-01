package com.example.abisatya;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList judul, catatan;
    DatabaseNote db;
    CustomAdapter(Context context, ArrayList judul, ArrayList catatan){
        this.catatan = catatan;
        this.judul = judul;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.tampilan, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvJudul.setText(String.valueOf(judul.get(position)));
        holder.tvCatatan.setText(String.valueOf(catatan.get(position)));


    }

    @Override
    public int getItemCount() {
        return judul.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvCatatan;
        Button btnDelete, btnEdit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCatatan = itemView.findViewById(R.id.tvCatatanHome);
            tvJudul = itemView.findViewById(R.id.tvJudulHome);
            btnDelete = itemView.findViewById(R.id.btnHapusNote);
            btnEdit = itemView.findViewById(R.id.btnEditNote);
        }
    }
}
