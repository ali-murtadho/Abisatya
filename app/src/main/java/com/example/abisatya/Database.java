package com.example.abisatya;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Database extends SQLiteOpenHelper {
    public static final String DB_NAME = "abisatya.db";
    public Database(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table catatan(id INTEGER PRIMARY KEY AUTOINCREMENT, teks TEXT)");
        db.execSQL("create table user(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, nama TEXT, password TEXT, telepon TEXT)");
        db.execSQL("create table diary(id INTEGER PRIMARY KEY AUTOINCREMENT, judul TEXT, teks_diary TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists catatan");
        db.execSQL("drop table if exists diary");
    }

    public Boolean insertDiary(String teks_diary, String judul){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("teks_diary", teks_diary);
        contentValues.put("judul", judul);
        long insertNotes = db.insert("diary", null, contentValues);
        if (insertNotes == -1){
            return false;
        }else {
            return true;
        }
    }
    public Boolean updateTeksDiary(String teks_diary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("teks_diary", teks_diary);
        Cursor cursor = db.rawQuery("SELECT * FROM diary WHERE teks_diary=?", new String[]{teks_diary});
        if (cursor.getCount() > 0){
            long update = db.update("diary", contentValues,"teks_diary=?",new String[] {teks_diary});
            if (update == -1){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }
    public Boolean updateJudulDiary(String judul){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("judul", judul);
        Cursor cursor = db.rawQuery("SELECT * FROM diary WHERE judul=?", new String[]{judul});
        if (cursor.getCount() > 0){
            long update = db.update("diary", contentValues,"judul=?",new String[] {judul});
            if (update == -1){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }
    public Boolean deleteDiary(String teks){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM diary WHERE teks_diary=?", new String[]{teks});
        if (cursor.getCount() > 0){
            long delete = db.delete("diary","teks_diary=?",new  String[]{teks});
            if (delete == -1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }
    public Cursor selectJudulDiary(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT judul FROM diary", null);
        return cursor;
    }
    public Cursor selectTeksDiary(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT teks_diary FROM diary", null);
        return cursor;
    }

    public Boolean insertNote(String teks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("teks", teks);
        long insertNotes = db.insert("catatan", null, contentValues);
        if (insertNotes == -1){
            return false;
        }else {
            return true;
        }
    }
    public Boolean updateNote(String teks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("teks", teks);
        Cursor cursor = db.rawQuery("SELECT * FROM catatan WHERE catatan=?", new String[]{teks});
        if (cursor.getCount() > 0){
            long update = db.update("user", contentValues,"teks=?",new String[] {teks});
            if (update == -1){
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }
    public Boolean deleteNote(String teks){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM catatan WHERE teks=?", new String[]{teks});
        if (cursor.getCount() > 0){
            long delete = db.delete("catatan","teks=?",new  String[]{teks});
            if (delete == -1){
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }
    public Cursor selectNote(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM catatan", null);
        return cursor;
    }

    public Boolean insertUser(String email, String nama, String password, String telepon){
     SQLiteDatabase db = this.getWritableDatabase();
     ContentValues contentValues = new ContentValues();
     contentValues.put("email", email);
     contentValues.put("nama", nama);
     contentValues.put("password", password);
     contentValues.put("telepon", telepon);
     long insert = db.insert("user", null, contentValues);
     if (insert == -1) {
         return false;
     }else {
         return true;
     }
    }
    public Boolean updatePassword(String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        long update = db.update("user", contentValues, "password=?", new String[]{password});
        if (update == -1){
            return false;
        }else {
            return true;
        }
    }
    public Boolean checkUser(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email = ?", new String[] {email});
        if (cursor.getCount() > 0 )
            return true;
        else
            return false;
    }

    public Boolean checkUserPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email = ? and password = ? ", new String[] {email, password});
        if (cursor.getCount() > 0 )
            return true;
        else
            return false;
    }
    public Boolean cekPassword(String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE password = ?", new String[] {password});
        if (cursor.getCount() > 0 )
            return true;
        else
            return false;
    }


}