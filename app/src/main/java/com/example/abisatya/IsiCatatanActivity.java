package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class IsiCatatanActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private TextView nCatatan, nJudul;
    private TextView finishnote;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_catatan);
        finishnote = findViewById(R.id.tvSelesai);
        nCatatan = findViewById(R.id.etCatatan);
        ibtnBack = findViewById(R.id.btnBack);
        nJudul = findViewById(R.id.etJudul);
        db = new Database(this);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(IsiCatatanActivity.this, CatatanActivity.class);
                startActivity(catatan);
            }
        });
        finishnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ambilCatatan = nCatatan.getText().toString();
                String ambilJudul = nJudul.getText().toString();

                        }
        });
    }
}