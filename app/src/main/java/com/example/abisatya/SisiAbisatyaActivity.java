package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SisiAbisatyaActivity extends AppCompatActivity {
    private ImageView ibtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sisi_abisatya);

        ibtnBack = findViewById(R.id.btnBack);

        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(SisiAbisatyaActivity.this, MainMenuActivity.class);
                startActivity(catatan);
            }
        });
    }
}