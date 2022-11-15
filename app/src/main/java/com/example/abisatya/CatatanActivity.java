package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CatatanActivity extends AppCompatActivity {
    CardView cCatatan;
    ImageView ibtnBack, ibtnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);

        cCatatan = findViewById(R.id.Catatan);
        cCatatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(CatatanActivity.this, IsiCatatanActivity.class);
                startActivity(catatan);
            }
        });

        ibtnBack = findViewById(R.id.btnBack);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(CatatanActivity.this, MainMenuActivity.class);
                startActivity(catatan);
            }
        });

        ibtnPlus = findViewById(R.id.btnPlus);
        ibtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(CatatanActivity.this, TambahCatatanActivity.class);
                startActivity(catatan);
            }
        });

    }
}