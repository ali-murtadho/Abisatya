package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DaftarAkunActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_akun);

        btnDaftar = findViewById(R.id.daftar_btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(DaftarAkunActivity.this, SuksesDaftarActivity.class);
                startActivity(catatan);
            }
        });

        ibtnBack = findViewById(R.id.btnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(DaftarAkunActivity.this, LoginActivity.class);
                startActivity(catatan);
            }
        });
    }
}