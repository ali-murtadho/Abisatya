package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

import java.io.IOException;

public class MainMenuActivity extends AppCompatActivity {
    private ConstraintLayout lCatatan, lSisiAbisatya;
    private Button btnLogout;
    private ShapeableImageView ibtnProfil;
    private TextView tvnama;
    String sNama;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        tvnama = findViewById(R.id.tvNama);
        btnLogout = findViewById(R.id.mm_btnLogout);
        lCatatan = findViewById(R.id.clCatatan);
        lSisiAbisatya = findViewById(R.id.clSisiAbisatya);
        db = new Database(this);
        getIntentData();
        Cursor cursor = db.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No Entries", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                tvnama.setText(""+cursor.getString(2));
            }
        }
        ibtnProfil = findViewById(R.id.imgProfil);
        ibtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(MainMenuActivity.this, ProfilActivity.class);
                startActivity(profil);
            }
        });

//        Uri imageUri = Uri.parse(getIntent().getExtras().getString("PROFIL"));
//        try {
//            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
//            ibtnProfil.setImageBitmap(bitmap);
//        } catch (IOException e) {
//            Toast.makeText(this, "Failed load images", Toast.LENGTH_SHORT).show();
//        }

        lCatatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catat = new Intent(MainMenuActivity.this, TambahCatatanActivity.class);
                startActivity(catat);
            }
        });

        lSisiAbisatya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sisi = new Intent(MainMenuActivity.this, SisiAbisatyaActivity.class);
                startActivity(sisi);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
                Intent logout = new Intent(MainMenuActivity.this, LoginActivity.class);
                startActivity(logout);
            }
        });
    }
    void getIntentData(){
        Cursor cursor = db.readAllData();
        if (getIntent().hasExtra("nama")){
            //Getting Data From Intent
            sNama = getIntent().getStringExtra("nama");
            //Setting Intent Data
            tvnama.setText(sNama);
        }
        else {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT);
        }
    }

}