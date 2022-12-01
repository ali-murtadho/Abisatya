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
import java.util.List;

public class CatatanActivity extends AppCompatActivity {
//    CardView cCatatan;
//    Button btnEdit, btnDelete;
    ImageView ibtnBack, ibtnPlus;
    DatabaseNote db;
    RecyclerView recyclerView1;
    ArrayList<String> judul, catatan;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);
        recyclerView1 = findViewById(R.id.recyclerView);
        ibtnBack = findViewById(R.id.btnBack);
        ibtnPlus = findViewById(R.id.btnPlus);
        db = new DatabaseNote(this);
        judul = new ArrayList<>();
        catatan = new ArrayList<>();
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatatanActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
        ibtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatatanActivity.this, TambahCatatanActivity.class);
                startActivity(intent);
            }
        });
        displayData();
        customAdapter = new CustomAdapter(CatatanActivity.this, judul, catatan);
        recyclerView1.setAdapter(customAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(CatatanActivity.this));
//        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView1.setHasFixedSize(true);



//        List<NoteModelClass> noteModelClasses = db.getNoteList();
//        if (noteModelClasses.size() > 0){
//            NoteAdapterClass noteAdapterClass = new NoteAdapterClass(noteModelClasses, CatatanActivity.this);
//            return;
//        }else {
//            Toast.makeText(this, "Belum ada Data", Toast.LENGTH_SHORT).show();
//        }

//        db = new DatabaseNote(this);
//        ibtnPlus = findViewById(R.id.btnPlus);
//        //btnEdit = findViewById(R.id.btnEditNote);
//        ibtnBack = findViewById(R.id.btnBack);
//        //cCatatan = findViewById(R.id.cvCatatan);
//
//        cCatatan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent lihat = new Intent(CatatanActivity.this, IsiCatatanActivity.class);
//                startActivity(lihat);
//            }
//        });
//
//
//        btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent edit = new Intent(CatatanActivity.this, EditCatatanMain.class);
//                startActivity(edit);
//            }
//        });
//        ibtnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent back = new Intent(CatatanActivity.this, MainMenuActivity.class);
//                startActivity(back);
//            }
//        });
//        ibtnPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent tambah = new Intent(CatatanActivity.this, TambahCatatanActivity.class);
//                startActivity(tambah);
//            }
//        });
//
//
//    }
//    void tampilData(){
//        Cursor cursor = db.readNote();
//        if (cursor.getCount() == 0) {
//            Toast.makeText(this, "Tidak ada data", Toast.LENGTH_SHORT).show();
//        } else {
//            while (cursor.moveToNext()) {
//                judulNote.add(cursor.getString(0));
//                catatanNote.add(cursor.getString(1));
//            }
//        }
//    }
    }
    void displayData(){
        Cursor cursor = db.readNote();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Belum ada data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                judul.add(cursor.getString(0));
                catatan.add(cursor.getString(1));
            }
        }
    }
}
