package com.example.likhitasuresh.miniproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.likhitasuresh.miniproject1.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseHandler(context);
    }


    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }


    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public List<String> getName() {

        List<String> list1 = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM stocks", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list1.add(cursor.getString(0));

            cursor.moveToNext();
        }
        cursor.close();
        return list1;
    }

    public List<String> getPrice() {
        List<String> price = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Price FROM stocks", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            price.add(cursor.getString(cursor.getColumnIndex("Price")));
            cursor.moveToNext();
        }
        cursor.close();
        return price;
    }

    public List<String> getName2() {
        List<String> name2 = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * from stocks", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            name2.add(cursor.getString(cursor.getColumnIndex("Name 2")));
            cursor.moveToNext();
        }
        cursor.close();
        return name2;
    }

    public String getChange(String n) {
        String price;
        Cursor cursor = database.rawQuery("SELECT * FROM stocks where Name=" + "\"" + n + "\"", null);
        cursor.moveToFirst();
        price = (cursor.getString(4));
        cursor.close();
        return price;
    }

    public String getChange2(String n) {
        String price;
        Cursor cursor = database.rawQuery("SELECT * FROM stocks where Name=" + "\"" + n + "\"", null);
        cursor.moveToFirst();
        price = (cursor.getString(5));
        cursor.close();
        return price;
    }
    public String getAbout(String n) {
        String price;
        Cursor cursor = database.rawQuery("SELECT * FROM stocks where Name=" + "\"" + n + "\"", null);
        cursor.moveToFirst();
        price = (cursor.getString(6));
        cursor.close();
        return price;
    }
    public ArrayList<Integer> getData(String n)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int i=0;
        Cursor cursor = database.rawQuery("SELECT"+"\""+n+"\"" +" FROM final",null);
        cursor.moveToFirst();

       while(!cursor.isLast())
        {
            a.add(cursor.getInt(cursor.getColumnIndex(n)));
            cursor.moveToNext();
            i++;
        }
        a.add(cursor.getInt(cursor.getColumnIndex(n)));
        cursor.close();
        return a;
    }

    public String getPass() {

        Cursor cursor = database.rawQuery("SELECT * FROM password ", null);
        cursor.moveToFirst();
        String price = (cursor.getString(0));
        cursor.close();
        return price;
    }


}
