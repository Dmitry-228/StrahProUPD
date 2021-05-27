package com.example.strahpro.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.strahpro.data.Strahovka;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DBAdapter(Context context){
        dbHelper = new DBHelper(context.getApplicationContext());
    }

    public DBAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    private Cursor getAllEntries(){
        String[] columns = new String[] {DBHelper.COLUMN_ID, DBHelper.COLUMN_DATE, DBHelper.COLUMN_PRICE};
        return  database.query(DBHelper.TABLE, columns, null, null, null, null, null);
    }

    public ArrayList<Strahovka> getStrahovki(){
        ArrayList<Strahovka> strahovki = new ArrayList<>();
        Cursor cursor = getAllEntries();
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID));
            String date = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DATE));
            Integer price = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_PRICE));
            strahovki.add(new Strahovka(id, date, price));
        }
        cursor.close();
        return  strahovki;
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DBHelper.TABLE);
    }

    public long insert(Strahovka s){

        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_DATE, s.getDate());
        cv.put(DBHelper.COLUMN_PRICE, s.getPrice());

        return  database.insert(DBHelper.TABLE, null, cv);
    }

}
