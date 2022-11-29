package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TambahCatatanActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private EditText nCatatan, nJudulC;
    private Database db;
    private TextView btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);
        nCatatan = findViewById(R.id.etCatatan);
        nJudulC = findViewById(R.id.etJudul);
        btnSimpan = findViewById(R.id.tvSave);
        db = new Database(this);
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
                if (judul.equals("") || catat.equals("")){
                    Toast.makeText(TambahCatatanActivity.this, "Catatan Masih Kosong nih", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean cekNote = db.checkNote(judul,catat);
                    if (cekNote == false) {
                        Boolean insertNote = db.insertNote(judul, catat);
                        if (insertNote == true) {
                            Toast.makeText(TambahCatatanActivity.this, "Catatanmu telah ditambah", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(TambahCatatanActivity.this, CatatanActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(TambahCatatanActivity.this, "Gagal menambah data", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(TambahCatatanActivity.this, "Catatan sudah ada", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}