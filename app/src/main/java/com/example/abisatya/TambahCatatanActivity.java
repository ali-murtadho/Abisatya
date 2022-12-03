package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TambahCatatanActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private EditText nCatatan, nJudulC, nWaktu;
    private TextView btnSimpan;
    int id=0;
    DatabaseNote db = new DatabaseNote(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);
        nCatatan = findViewById(R.id.etCatatan);
        nJudulC = findViewById(R.id.etJudul);
        nWaktu = findViewById(R.id.etWaktu);
        btnSimpan = findViewById(R.id.tvSave);
        ibtnBack = findViewById(R.id.btnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(TambahCatatanActivity.this, CatatanActivity.class);
                startActivity(catatan);
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String judul = nJudulC.getText().toString();
                String catat = nCatatan.getText().toString();
                String waktu = nWaktu.getText().toString();
                Boolean insertnote = db.CreateNote(judul, catat, waktu);
                    if (insertnote) {
                        Toast.makeText(TambahCatatanActivity.this, "Berhasil menambahkan catatan", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TambahCatatanActivity.this, CatatanActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(TambahCatatanActivity.this, "Data Gagal ditambah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}