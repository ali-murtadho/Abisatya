package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfilActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private Button btnSimpan;
    private EditText etTentang, etNama, etTelpon, etEmaill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        etTentang = findViewById(R.id.etTentang);
        etNama = findViewById(R.id.etNama);
        etTelpon = findViewById(R.id.etNoTelpon);
        etEmaill = findViewById(R.id.etEmail);

        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(ProfilActivity.this, MainMenuActivity.class);
                startActivity(catatan);
            }
        });

        ibtnBack = findViewById(R.id.btnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(ProfilActivity.this, MainMenuActivity.class);
                startActivity(catatan);
            }
        });
    }
}