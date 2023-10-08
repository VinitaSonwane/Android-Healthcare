package com.example.healthcareproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(Username text , email text , password text)";
        sqLiteDatabase.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Handle database upgrades here if needed
    }
    public long register(String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("Username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert("users", null, cv); // Table name should be "users" not "Users"
        db.close();
        return result;
    }public int login(String username, String password) {
        int result = 0;
        String[] str = {username, password};
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where Username = ? and password = ?", str); // Table name should be "users" not "user"
        if (c.moveToFirst()) {
            result = 1;
        }
        c.close();
        db.close();
        return result;
    }
}
