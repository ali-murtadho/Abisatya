package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class TambahCatatanActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private EditText nDiary, nJudulD;
    private Database db;
    private TextView btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_catatan);
        nDiary = findViewById(R.id.etTeksDiary);
        nJudulD = findViewById(R.id.etJudul);
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

            }
        });
    }
}