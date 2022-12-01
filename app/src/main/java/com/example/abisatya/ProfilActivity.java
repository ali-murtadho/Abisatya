package com.example.abisatya;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

import java.io.IOException;

public class ProfilActivity extends AppCompatActivity {
    private static final int PROFIL_REQUEST_CODE = 1;

    private String sTentang, sNama, sTelpon, sEmail;
    private ImageView ibtnProfil, imgProfil, iProfil;
    private ShapeableImageView fotoProfil;
    private boolean change_img_profil = false;
    private String uriString = null;
    private Uri imagePath;
    private Bitmap imageToStore;

    private ImageView ibtnBack, image;
    private Button btnSimpanAbout;
    private EditText etAbout, etNama, etTelpon, etEmail;

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        db = new Database(this);
        getAndSetIntentData();

        ibtnProfil = findViewById(R.id.btnProfil);
        imgProfil = findViewById(R.id.imgProfil);
        image = findViewById(R.id.btnImage);
        btnSimpanAbout = findViewById(R.id.btnSimpan);
        ibtnBack = findViewById(R.id.btnBack);

        fotoProfil = findViewById(R.id.imgProfil);
        etAbout = findViewById(R.id.etTentang);
        etNama = findViewById(R.id.etNama);
        etTelpon = findViewById(R.id.etNoTelpon);
        etEmail = findViewById(R.id.etEmail);

        Cursor cursor = db.getUser();
        if (cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No Entries", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                etAbout.setText(""+cursor.getString(5));
                etNama.setText(""+cursor.getString(2));
                etTelpon.setText(""+cursor.getString(4));
                etEmail.setText(""+cursor.getString(1));
                byte[] imageByte = cursor.getBlob(4);
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte,0, imageByte.length);
                fotoProfil.setImageBitmap(bitmap);
            }
        }
        ibtnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), PROFIL_REQUEST_CODE);
            }
        });
        btnSimpanAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeImage();
//                sNama = etNama.getText().toString();
//                sTelpon = etTelpon.getText().toString();
//                sEmail = etEmail.getText().toString();
//                sTentang = etTelpon.getText().toString();
//                byte[] imageByte = cursor.getBlob(4);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte,0, imageByte.length);
//                fotoProfil.setImageBitmap(bitmap);
//                Database.updateProfil(new ModelClass(ModelClass.getNama(), sTelpon, sTelpon, sTentang,imageToStore ));
            }
        });
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(ProfilActivity.this, MainMenuActivity.class);
                startActivity(catatan);
            }
        });
        fotoProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choceImage();
            }
        });
    }

    private void choceImage() {
        try {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, PROFIL_REQUEST_CODE);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PROFIL_REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null){
                imagePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(),imagePath);
                fotoProfil.setImageBitmap(imageToStore);
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private  void storeImage(){
        if (!etAbout.getText().toString().isEmpty() && !etNama.getText().toString().isEmpty()
                && !etTelpon.getText().toString().isEmpty() && !etEmail.getText().toString().isEmpty()
                && fotoProfil.getDrawable() != null & imageToStore != null){

            db.updateProfil(new ModelClass(etAbout.getText().toString(), etNama.getText().toString(), etTelpon.getText().toString(),
                    etEmail.getText().toString(), imageToStore));
            Intent intent = new Intent(ProfilActivity.this, MainMenuActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Please fiil al the fields", Toast.LENGTH_SHORT).show();
        }
    }

    void getAndSetIntentData(){
        Cursor cursor = db.getUser();
        if (getIntent().hasExtra("tentang") &&
                getIntent().hasExtra("nama") &&
                getIntent().hasExtra("telepon") &&
                getIntent().hasExtra("email")){

            //Getting Data From Intent
            sTentang = getIntent().getStringExtra("tentang");
            sNama = getIntent().getStringExtra("nama");
            sTelpon = getIntent().getStringExtra("telepon");
            sEmail = getIntent().getStringExtra("enail");

            //Setting Intent Data
            etAbout.setText(sTentang);
            etNama.setText(sNama);
            etTelpon.setText(sTelpon);
            etEmail.setText(sEmail);
        }
        else {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_CANCELED){
//            Toast.makeText(this, "Canceled pick images", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == PROFIL_REQUEST_CODE){
//            if (data != null){
//                try {
//                    Uri imageUri = data.getData();
//                    uriString = imageUri.toString();
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
//                    iProfil.setImageBitmap(bitmap);
//                } catch (IOException e){
//                    Toast.makeText(this, "Failed load images", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//    }
}