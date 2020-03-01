package com.example.userregestration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import static android.widget.Toast.*;

public class MyDatabase extends SQLiteOpenHelper {
    //private static final String TAG =MyDatabase.

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "USERS_table";
    //public static final String COL_1 = "ID";
    public static final String COL_1 = "FULL_NAME";
    public static final String COL_2 = "USER_NAME";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "GENDER";
    public static final String COL_6 = "PHONE_NUMBER";



    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME + " ( USER_NAME TEXT PRIMARY KEY, FULL_NAME TEXT,PASSWORD TEXT,EMAIL TEXT,GENDER TEXT,PHONE_NUMBER INTEGER)");
        //Toast.makeText(MyDatabase.this, "data not inserted", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String full_name, String user_name, String password, String email, String gender, String phone_number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, full_name);
        contentValues.put(COL_2, user_name);
        contentValues.put(COL_3, password);
        contentValues.put(COL_4, email);
        contentValues.put(COL_5, gender);
        contentValues.put(COL_6, phone_number);
        long result = db.insert( TABLE_NAME,null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, " USER_NAME =? ", new String[]{id});
    }

    public Cursor userLoginCheck(String user_name) {
        try {
            String qry = "Select fname,password from RegistrationTable where USER_NAME='" + user_name + "'";
            SQLiteDatabase db = getWritableDatabase();
            Cursor c = db.rawQuery(qry, null);
            return c;
        } catch (Exception e) {
            //Log.e(TAG, "Login Field", e);
            final Cursor o = null;
            return o;

        }
    }
}
