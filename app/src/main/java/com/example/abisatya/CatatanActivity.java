package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CatatanActivity extends AppCompatActivity {
    CardView cCatatan;
    Button btnEdit, btnDelete;
    ImageView ibtnBack, ibtnPlus;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);

        cCatatan = findViewById(R.id.cvCatatan);
        cCatatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lihat = new Intent(CatatanActivity.this, IsiCatatanActivity.class);
                startActivity(lihat);
            }
        });
        db = new Database(this);
        btnDelete = findViewById(R.id.btnHapusNote);
        btnEdit = findViewById(R.id.btnEditNote);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(CatatanActivity.this, EditCatatanMain.class);
                startActivity(edit);
            }
        });

        ibtnBack = findViewById(R.id.btnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(CatatanActivity.this, MainMenuActivity.class);
                startActivity(back);
            }
        });

        ibtnPlus = findViewById(R.id.btnPlus);
        ibtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tambah = new Intent(CatatanActivity.this, TambahCatatanActivity.class);
                startActivity(tambah);
            }
        });

    }
}