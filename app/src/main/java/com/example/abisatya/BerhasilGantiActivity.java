package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BerhasilGantiActivity extends AppCompatActivity {
    private TextView tvbtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil_ganti);

        tvbtnLogin = findViewById(R.id.tvLogin);
        tvbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(BerhasilGantiActivity.this, LoginActivity.class);
                startActivity(catatan);
            }
        });
    }
}