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
    private EditText nCatatan;
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
                if (ambilCatatan.equals("")){
                    Toast.makeText(IsiCatatanActivity.this, "Catatan belum ditambahkan", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean insertNote = db.insertNote(ambilCatatan);
                    if (insertNote == true){
                        Toast.makeText(IsiCatatanActivity.this, "Catatan berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(IsiCatatanActivity.this, MainMenuActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(IsiCatatanActivity.this, "Catatan Gagal ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}