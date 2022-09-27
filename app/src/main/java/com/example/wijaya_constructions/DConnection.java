package com.example.wijaya_constructions;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DConnection extends SQLiteOpenHelper {


    public DConnection(@Nullable Context con) {
        super(con, "w_database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE addsite(sitename text,siteid text,handoverDate text, handoutDate text,cost text)");
        db.execSQL("CREATE TABLE admin(firstname text,lastname text,email text, username text,password text)");
        db.execSQL("CREATE TABLE supervisor(firstname text,lastname text,email text ,password text,site text,username text)");
        db.execSQL("CREATE TABLE worker(firstname text,lastname text,phone text ,site text,id text,username text)");
        db.execSQL("CREATE TABLE MarkAtendance(username text,presentdate,absentdate text)");


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
