package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private TextView tvDaftar, tvbtnLupa;
    private Button btnLogin;
    private EditText inEmail, inPassword;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new Database(this);
        inEmail = findViewById(R.id.etEmail);
        inPassword = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.login_btnLogin);
        tvbtnLupa = findViewById(R.id.login_tvLupaPassword);
        tvDaftar = findViewById(R.id.login_tvDaftar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = inEmail.getText().toString();
                String strPassword = inPassword.getText().toString();
                if (strEmail.equals("") || strPassword.equals("")){
                    Toast.makeText(LoginActivity.this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean cekUser = db.checkUserPassword(strEmail, strPassword);
                    if (cekUser == true){
                        Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                        Intent toHome = new Intent(LoginActivity.this, MainMenuActivity.class);
                        startActivity(toHome);
                    }else {
                        Toast.makeText(LoginActivity.this, "email atau password salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(LoginActivity.this, DaftarAkunActivity.class);
                startActivity(catatan);
            }
        });
        tvbtnLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(LoginActivity.this, LupaPasswordActivity.class);
                startActivity(catatan);
            }
        });
    }
}