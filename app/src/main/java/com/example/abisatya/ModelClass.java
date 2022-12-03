package com.example.abisatya;

import android.graphics.Bitmap;

public class ModelClass {

    private String tentang;
    private static String nama;
    private String telepon;
    private String email;
    private Bitmap fotoProfil;

    public ModelClass(String tentang, String nama, String telepon, String email, Bitmap fotoProfil)
    {
        this.tentang = tentang;
        this.nama = nama;
        this.telepon = telepon;
        this.email = email;
        this.fotoProfil = fotoProfil;
    }

    public String getTentang() {
        return tentang;
    }

    public void setTentang(String tentang) {
        this.tentang = tentang;
    }

    public static String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bitmap getFotoProfil() {
        return fotoProfil;
    }

    public void setFotoProfil(Bitmap fotoProfil) {
        this.fotoProfil = fotoProfil;
    }
}