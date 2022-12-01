package com.example.abisatya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapterClass extends RecyclerView.Adapter<NoteAdapterClass.ViewHolder>{
    List<NoteModelClass> note;
    Context context;
    DatabaseNote db;

    public NoteAdapterClass(List<NoteModelClass> note, Context context) {
        this.note = note;
        this.context = context;
        db = new DatabaseNote(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.tampilan, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NoteModelClass noteModelClass = note.get(position);
        holder.tvCatatan.setText(noteModelClass.getCatatan());
        holder.tvJudul.setText(noteModelClass.getJudul());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvJudul, tvCatatan, tvWaktu;
        Button btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWaktu = itemView.findViewById(R.id.waktu);
            tvJudul = itemView.findViewById(R.id.tvJudulHome);
            tvCatatan = itemView.findViewById(R.id.tvCatatanHome);
            btnDelete = itemView.findViewById(R.id.btnHapusNote);
            btnEdit = itemView.findViewById(R.id.btnEditNote);
        }
    }
}
