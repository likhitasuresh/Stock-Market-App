package com.example.likhitasuresh.miniproject1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseHandler extends SQLiteAssetHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "stocks5db.db";

    public DatabaseHandler(Context c)
    {
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
    }


}
