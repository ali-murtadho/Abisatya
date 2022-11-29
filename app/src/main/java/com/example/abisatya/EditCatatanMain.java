package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditCatatanMain extends AppCompatActivity {
    private ImageView ibtnBack;
    private EditText nCatatan;
    private TextView finishnote;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_catatan_main);
        finishnote = findViewById(R.id.tvSelesai);
        nCatatan = findViewById(R.id.etCatatan);
        ibtnBack = findViewById(R.id.btnBack);
        db = new Database(this);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(EditCatatanMain.this, CatatanActivity.class);
                startActivity(catatan);
            }
        });
        finishnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ambilCatatan = nCatatan.getText().toString();
                if (ambilCatatan.equals("")){
                    Toast.makeText(EditCatatanMain.this, "Catatan belum ditambahkan", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean insertNote = db.insertNote(ambilCatatan);
                    if (insertNote == true){
                        Toast.makeText(EditCatatanMain.this, "Catatan berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditCatatanMain.this, MainMenuActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(EditCatatanMain.this, "Catatan Gagal ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}