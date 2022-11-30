package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CatatanActivity extends AppCompatActivity {
    CardView cCatatan;
    Button btnEdit, btnDelete;
    ImageView ibtnBack, ibtnPlus;
    DatabaseNote db;
    ArrayList<String> judulNote, catatanNote;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);
        db = new DatabaseNote(this);
        btnDelete = findViewById(R.id.btnHapusNote);
        ibtnPlus = findViewById(R.id.btnPlus);
        btnEdit = findViewById(R.id.btnEditNote);
        ibtnBack = findViewById(R.id.btnBack);
        recyclerView = findViewById(R.id.recylclerview1);
        judulNote = new ArrayList<>();
        catatanNote = new ArrayList<>();
        cCatatan = findViewById(R.id.cvCatatan);
        tampilData();
        customAdapter = new CustomAdapter(CatatanActivity.this, judulNote, catatanNote);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(CatatanActivity.this));
        cCatatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lihat = new Intent(CatatanActivity.this, IsiCatatanActivity.class);
                startActivity(lihat);
            }
        });


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(CatatanActivity.this, EditCatatanMain.class);
                startActivity(edit);
            }
        });
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(CatatanActivity.this, MainMenuActivity.class);
                startActivity(back);
            }
        });
        ibtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tambah = new Intent(CatatanActivity.this, TambahCatatanActivity.class);
                startActivity(tambah);
            }
        });


    }
    void tampilData(){
        Cursor cursor = db.readNote();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Tidak ada data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                judulNote.add(cursor.getString(0));
                catatanNote.add(cursor.getString(1));
            }
        }
    }
}
