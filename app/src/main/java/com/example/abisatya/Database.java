package com.example.abisatya;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
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
    private static final String TENTANG = "tentang";
    private static final String FOTO = "foto";

    private static ByteArrayOutputStream byteArrayOutputStream;
    private static byte[] imageInBytes;

    public Database(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String user = "CREATE TABLE " + TABLE_NAME_1 +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, nama TEXT, password TEXT, telepon TEXT, tentang TEXT, foto BLOB)";
        db.execSQL(user);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
        onCreate(db);
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

    public void updateProfil(ModelClass modelClass){
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap imageToStoreBitmap = modelClass.getFotoProfil();

        byteArrayOutputStream = new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        imageInBytes = byteArrayOutputStream.toByteArray();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.NAMA,modelClass.getNama());
        contentValues.put("tentang", modelClass.getTentang());
        contentValues.put("nama", modelClass.getNama());
        contentValues.put("telepon", modelClass.getTelepon());
        contentValues.put("email", modelClass.getEmail());
        contentValues.put("foto", imageInBytes);

        long checkIfQueryRun = db.update("user",contentValues,NAMA+" =?", new String[]{
                String.valueOf(ModelClass.class)});
//        if (checkIfQueryRun != -1) {
//            Toast.makeText(context.getApplicationContext(), "table add succesfully", Toast.LENGTH_SHORT).show();
//            db.close();
//        }
//        else {
//            Toast.makeText(context.getApplicationContext(), "fail to add", Toast.LENGTH_SHORT).show();
//        }
    }

    public Cursor getUser(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user", null);
        return cursor;
    }

    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME_1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
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