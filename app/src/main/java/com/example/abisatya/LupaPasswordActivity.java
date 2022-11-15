package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LupaPasswordActivity extends AppCompatActivity {
    private Button btnKirim;
    private ImageView ibtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        btnKirim = findViewById(R.id.lupa_btnKirim);
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(LupaPasswordActivity.this, ResetPasswordActivity.class);
                startActivity(catatan);
            }
        });

        ibtnBack = findViewById(R.id.btnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(LupaPasswordActivity.this, LoginActivity.class);
                startActivity(catatan);
            }
        });
    }
}