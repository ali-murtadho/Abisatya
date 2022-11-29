package com.example.abisatya;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.concurrent.RecursiveTask;

import kotlin.contracts.Returns;


public class Database extends SQLiteOpenHelper {
    Context context;
    public static final String DB_NAME = "abisatya.db";
    public Database(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, nama TEXT, password TEXT, telepon TEXT)");
        db.execSQL("create table note(id INTEGER PRIMARY KEY AUTOINCREMENT, judul TEXT, catatan TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists note");
    }
//    public Boolean checkNote(String judul, String catatan){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from note where judul = ?", new String[] {judul, catatan});
//        if (cursor.getCount() > 0 )
//            return true;
//        else
//            return false;
//    }
//    public Boolean insertNote(String judul, String catatan){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("teks", catatan);
//        contentValues.put("judul", judul);
//        long insertNotes = db.insert("note", null, contentValues);
//        if (insertNotes == -1){
//            return false;
//        }else {
//            return true;
//        }
//    }
////    public void insertNote(String judul, String catatan){
////        SQLiteDatabase db = this.getWritableDatabase();
////        ContentValues contentValues = new ContentValues();
////        contentValues.put("judul", judul);
////        contentValues.put("catatan", catatan);
////        long insert = db.insert("note",null,contentValues);
////        if (insert == -1){
////            Toast.makeText(TambahCatatanActivity, "", Toast.LENGTH_SHORT).show();
////        }
////    }
//    public Boolean updateNote(String judul, String catatan){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("teks", catatan);
//        contentValues.put("judul", judul);
//        Cursor cursor = db.rawQuery("SELECT * FROM note WHERE judul=?", new String[]{judul, catatan});
//        if (cursor.getCount() > 0){
//            long update = db.update("note", contentValues,"judul=?",new String[] {judul, catatan});
//            if (update == -1){
//                return false;
//            }else {
//                return true;
//            }
//        }else {
//            return false;
//        }
//    }
//    public Boolean deleteNote(String judul, String catatan){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM note WHERE judul=?", new String[]{catatan, judul});
//        if (cursor.getCount() > 0){
//            long delete = db.delete("note","judul=?",new  String[]{catatan, judul});
//            if (delete == -1){
//                return false;
//            }else {
//                return true;
//            }
//        }else{
//            return false;
//        }
//    }
//    public Cursor readNote(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = null;
//        if (cursor != null){
//            cursor = db.rawQuery("SELECT * FROM note", null);
//        }
//        return cursor;
//    }

    Boolean insertNote(String judul, String catatan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("judul", judul);
        contentValues.put("catatan", catatan);
        long insert = db.insert("note", null, contentValues);
        if (insert == -1){
            return false;
        }else {
            return true;
        }
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