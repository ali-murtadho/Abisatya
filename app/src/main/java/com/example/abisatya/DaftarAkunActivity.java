package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DaftarAkunActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private Button btnDaftar;
    private EditText nNama, nEmail, nPassword, nTelepon;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_akun);
        db = new Database(this);
        nNama = findViewById(R.id.regNama);
        nPassword = findViewById(R.id.regPassword);
        nEmail = findViewById(R.id.regEmail);
        nTelepon = findViewById(R.id.regTelepon);
        ibtnBack = findViewById(R.id.btnBack);
        btnDaftar = findViewById(R.id.daftar_btnDaftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iNama = nNama.getText().toString();
                String iEmail = nEmail.getText().toString();
                String iPassword = nPassword.getText().toString();
                String iTelepon = nTelepon.getText().toString();
                if (iEmail.equals("") || iPassword.equals("") || iTelepon.equals("") || iNama.equals("")){
                    Toast.makeText(DaftarAkunActivity.this, "Tidak Boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean cekUser = db.checkUser(iEmail);
                    if (cekUser == false){
                        Boolean insert = db.insertUser(iEmail, iNama, iPassword, iTelepon);
                        if (insert == true){
                            Toast.makeText(DaftarAkunActivity.this, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show();
                            Intent toSuccessRegist = new Intent(DaftarAkunActivity.this, SuksesDaftarActivity.class);
                            startActivity(toSuccessRegist);
                        }else{
                            Toast.makeText(DaftarAkunActivity.this, "Gagal Mendaftar", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(DaftarAkunActivity.this, "User sudah ada", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(DaftarAkunActivity.this, LoginActivity.class);
                startActivity(catatan);
            }
        });
    }
}