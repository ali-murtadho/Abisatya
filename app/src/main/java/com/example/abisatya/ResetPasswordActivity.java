package com.example.abisatya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ResetPasswordActivity extends AppCompatActivity {
    private ImageView ibtnBack;
    private Button btnSimpan;
    private EditText nPassword, ncPassword;
    private Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        db = new Database(this);
        nPassword = findViewById(R.id.newPassword);
        ncPassword = findViewById(R.id.newConfirmPassword);
        ibtnBack = findViewById(R.id.btnBack);
        btnSimpan = findViewById(R.id.reset_btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password_baru = nPassword.getText().toString();
                String password_baru_confirm = ncPassword.getText().toString();
                //Boolean cekP = db.cekPassword(password_baru);

                if (password_baru.equals("") || password_baru_confirm.equals("")) {
                    Toast.makeText(ResetPasswordActivity.this, "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    if (password_baru == password_baru_confirm){
                        Boolean updatePass = db.updatePassword(password_baru);
                        Toast.makeText(ResetPasswordActivity.this, "Berhasil Reset Password", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ResetPasswordActivity.this, BerhasilGantiActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(ResetPasswordActivity.this, "Password harus sama", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catatan = new Intent(ResetPasswordActivity.this, LupaPasswordActivity.class);
                startActivity(catatan);
            }
        });
    }
}