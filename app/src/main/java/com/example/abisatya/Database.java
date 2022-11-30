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
    public static final String DB_NAME = "abisatyaa.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_1 = "user";
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String NAMA = "nama";
    private static final String TELEPON = "telepon";

    public Database(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String userr = "CREATE TABLE " + TABLE_NAME_1 +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, nama TEXT, password TEXT, telepon TEXT, tentang TEXT)";
        db.execSQL(userr);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
        onCreate(db);
    }

    public Boolean insertProfil(String email, String nama, String telepon, String tentang){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("nama", nama);
        contentValues.put("telepon", telepon);
        contentValues.put("tentang", tentang);
        long insert = db.insert("user", null, contentValues);
        if (insert == -1) {
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