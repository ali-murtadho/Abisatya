package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    private TextView tvDaftar, tvbtnLupa;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.login_btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MainMenuActivity.class);
                startActivity(i);
            }
        });

        tvDaftar = findViewById(R.id.login_tvDaftar);
        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(LoginActivity.this, DaftarAkunActivity.class);
                startActivity(catatan);
            }
        });

        tvbtnLupa = findViewById(R.id.login_tvLupaPassword);
        tvbtnLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(LoginActivity.this, LupaPasswordActivity.class);
                startActivity(catatan);
            }
        });
    }
}