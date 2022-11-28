package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LupaPasswordActivity extends AppCompatActivity {
    private Button btnKirim;
    private ImageView ibtnBack;
    private EditText cEmail;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);
        cEmail = findViewById(R.id.cekEmail);
        db = new Database(this);
        btnKirim = findViewById(R.id.lupa_btnKirim);
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strcEmail = cEmail.getText().toString();
                if (strcEmail.equals("")){
                    Toast.makeText(LupaPasswordActivity.this, "Tidak Boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean CheckEmail = db.checkUser(strcEmail);
                    if (CheckEmail == true){
                        Toast.makeText(LupaPasswordActivity.this, "Data Sudah dikirim", Toast.LENGTH_SHORT).show();
                        Intent toLoginA = new Intent(LupaPasswordActivity.this, ResetPasswordActivity.class);
                        startActivity(toLoginA);
                    }else {
                        Toast.makeText(LupaPasswordActivity.this, "Email Salah", Toast.LENGTH_SHORT).show();
                    }
                }
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