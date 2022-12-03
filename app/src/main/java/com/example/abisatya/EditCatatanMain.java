package com.example.abisatya;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditCatatanMain extends AppCompatActivity {
    private ImageView ibtnBack;
    private EditText upCatatan, upJudul, upWaktu;
    private TextView update, hapus;
    String judul, catatan, waktu;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_catatan_main);
        update = findViewById(R.id.tvUpdate);
        upCatatan = findViewById(R.id.etCatatanUpdate);
        ibtnBack = findViewById(R.id.btnBackUpdate);
        upJudul = findViewById(R.id.etJudulUpdate);
        upWaktu = findViewById(R.id.etWaktuUpdate);
        hapus = findViewById(R.id.tvHapus);
        db = new Database(this);

        getIntentData();
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(EditCatatanMain.this, CatatanActivity.class);
                startActivity(catatan);
            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmDialog();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseNote databaseNote = new DatabaseNote(EditCatatanMain.this);
                Boolean update = databaseNote.updateNote(judul, catatan, waktu);
                if (update == true){
                    Toast.makeText(EditCatatanMain.this, "Berhasil diubah", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EditCatatanMain.this, CatatanActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(EditCatatanMain.this, "Gagal Mengubah", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    void ConfirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Menghapus" + judul + " ?");
        builder.setMessage("Apakah yakin?");
        builder.setPositiveButton("iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseNote databaseNote = new DatabaseNote(EditCatatanMain.this);
                databaseNote.deleteNote(judul);
            }
        });
        builder.setNegativeButton("tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
    void getIntentData(){
        if (getIntent().hasExtra("judul") && getIntent().hasExtra("catatan") && getIntent().hasExtra("waktu")){
            judul = getIntent().getStringExtra("judul");
            catatan = getIntent().getStringExtra("catatan");
            waktu = getIntent().getStringExtra("waktu");

            upJudul.setText(judul);
            upCatatan.setText(catatan);
            upWaktu.setText(waktu);
        }else {
            Toast.makeText(this, "Tidak ada data", Toast.LENGTH_SHORT).show();
        }
    }
}