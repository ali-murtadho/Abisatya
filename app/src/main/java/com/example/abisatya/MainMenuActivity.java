package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {
    private ConstraintLayout lKalendar, lCatatan, lSisiAbisatya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        lCatatan = findViewById(R.id.clCatatan);
        lCatatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catat = new Intent(MainMenuActivity.this, CatatanActivity.class);
                startActivity(catat);
            }
        });
    }
}