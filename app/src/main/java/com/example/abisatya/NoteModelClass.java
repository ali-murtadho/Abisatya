package com.example.abisatya;

public class NoteModelClass {
    Integer id;
    String judul;
    String catatan;

    public NoteModelClass(String judul, String catatan){
        this.judul = judul;
        this.catatan = catatan;
    }

    public NoteModelClass(Integer id, String judul, String catatan) {
        this.id = id;
        this.judul = judul;
        this.catatan = catatan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
