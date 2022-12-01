package com.example.abisatya;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseNote extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "abisatyaNote.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "note";
    private static final String ID = "id";
    private static final String JUDUL = "judul";
    private static final String CATATAN = "catatan";
    private String query = "CREATE TABLE note (id INTEGER PRIMARY KEY AUTOINCREMENT, judul TEXT, catatan TEXT)";

    public DatabaseNote( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS note");
        db.execSQL(query);
        onCreate(db);
    }


    public Boolean CreateNote(String judul, String catatan){
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
    public Boolean updateNote(String judul, String catatan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("judul", judul);
        contentValues.put("catatan", catatan);
        long update = db.update(TABLE_NAME, contentValues, "judul=?", new String[]{judul, catatan});
        if (update == -1){
            return false;
        }else {
            return true;
        }
    }
    Cursor readNote(){
        String query = "SELECT * FROM note";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    public Boolean deleteNote(String judul){
        SQLiteDatabase db = this.getWritableDatabase();
        long delete = db.delete(TABLE_NAME,"judul=?", new String[]{judul});
        if (delete == -1){
            return false;
        }else {
            return true;
        }
    }

    public List<NoteModelClass> getNoteList(){
        String sql = "SELECT * FROM note";
        SQLiteDatabase dbRead= this.getReadableDatabase();
        List<NoteModelClass> storeNote = new ArrayList<>();
        Cursor cursor = dbRead.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String judul = cursor.getString(1);
                String catatan = cursor.getString(2);
                storeNote.add(new NoteModelClass(id, judul, catatan));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeNote;
    }
    public void updateNote(NoteModelClass noteModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseNote.JUDUL, noteModelClass.getJudul());
        contentValues.put(DatabaseNote.CATATAN, noteModelClass.getCatatan());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update("note", contentValues, "id=?", new String[]{String.valueOf(noteModelClass.getId())});
    }

    public void deleteNote(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("note","id=?", new String[]{String.valueOf(id)});
    }

}
