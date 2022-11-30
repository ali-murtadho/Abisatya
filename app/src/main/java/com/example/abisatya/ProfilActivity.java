package com.example.abisatya;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class ProfilActivity extends AppCompatActivity {
    private static final int PROFIL_REQUEST_CODE = 1;

    private String sTentang, sNama, sTelpon, sEmail;
    private ImageView ibtnProfil, imgProfil, iProfil;
    private boolean change_img_profil = false;
    private String uriString = null;

    private ImageView ibtnBack, image;
    private Button btnSimpanAbout;
    private EditText etAbout, etNama, etTelpon, etEmaill;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        ibtnProfil = findViewById(R.id.btnProfil);
        imgProfil = findViewById(R.id.imgProfil);

        ibtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), PROFIL_REQUEST_CODE);
            }
        });
        db = new Database(this);
        image = findViewById(R.id.btnImage);
        etAbout = findViewById(R.id.etTentang);
        etNama = findViewById(R.id.etNama);
        etTelpon = findViewById(R.id.etNoTelpon);
        etEmaill = findViewById(R.id.etEmail);
        btnSimpanAbout = findViewById(R.id.btnSimpan);
        btnSimpanAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(ProfilActivity.this, ProfilActivity.class);
                catatan.putExtra("PROFIL", uriString);
                catatan.putExtra("TENTANG", sTentang);
                startActivity(catatan);
            }
        });
        //etTentang.setText(sTentang);

        ibtnBack = findViewById(R.id.btnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String about = etAbout.getText().toString();
                String telepon = etTelpon.getText().toString();
                String email = etEmaill.getText().toString();
                Boolean inProfil = db.insertProfil(email,nama, telepon, about);
                if (inProfil == true){
                Intent catatan = new Intent(ProfilActivity.this, MainMenuActivity.class);
                startActivity(catatan);
                }else {
                    Toast.makeText(ProfilActivity.this, "Coba Lagi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Canceled pick images", Toast.LENGTH_SHORT).show();
        } else if (requestCode == PROFIL_REQUEST_CODE){
            if (data != null){
                try {
                    Uri imageUri = data.getData();
                    uriString = imageUri.toString();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    iProfil.setImageBitmap(bitmap);
                } catch (IOException e){
                    Toast.makeText(this, "Failed load images", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}