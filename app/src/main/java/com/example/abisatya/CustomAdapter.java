package com.example.abisatya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList judul, catatan;


    CustomAdapter(Context context, ArrayList judul, ArrayList catatan){
        this.context = context;
        this.judul = judul;
        this.catatan = catatan;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_catatan, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.etJudul.setText(String.valueOf(judul.get(position)));
        holder.etCatatan.setText(String.valueOf(catatan.get(position)));
    }

    @Override
    public int getItemCount() {
        return judul.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView etJudul, etCatatan;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            etJudul = itemView.findViewById(R.id.etJudulHome);
            etCatatan = itemView.findViewById(R.id.etCatatanHome);
        }
    }
}
