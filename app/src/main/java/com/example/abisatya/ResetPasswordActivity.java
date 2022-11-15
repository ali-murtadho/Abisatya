package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResetPasswordActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        btnSimpan = findViewById(R.id.reset_btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(ResetPasswordActivity.this, BerhasilGantiActivity.class);
                startActivity(catatan);
            }
        });

        ibtnBack = findViewById(R.id.btnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(ResetPasswordActivity.this, LupaPasswordActivity.class);
                startActivity(catatan);
            }
        });
    }
}