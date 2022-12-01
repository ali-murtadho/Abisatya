package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private static final int SELECT_PICTURE = 1;
    private static final String TAG = "MainMenuActivity";

    private String sNama;
    private TextView tvNama;
    private ConstraintLayout lCatatan, lSisiAbisatya;
    private Button btnLogout;
    private ShapeableImageView ibtnProfil;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        db = new Database(this);
        getIntentData();

        btnLogout = findViewById(R.id.mm_btnLogout);
        lCatatan = findViewById(R.id.clCatatan);
        lSisiAbisatya = findViewById(R.id.clSisiAbisatya);
        tvNama = findViewById(R.id.mm_tvNama);
        ibtnProfil = (ShapeableImageView)findViewById(R.id.imgProfil);

        Cursor cursor = db.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No Entries", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                tvNama.setText(""+cursor.getString(2));
            }
        }

        ibtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profil = new Intent(MainMenuActivity.this, ProfilActivity.class);
                startActivity(profil);
            }
        });


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
            tvNama.setText(sNama);
        }
        else {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT);
        }
    }

}