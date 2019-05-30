package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.DataAccess.DataBase.Database;
import com.example.bank_app.DataAccess.Models.Account;

public class AccountRepository {
    Context context;
    Database db;
    public AccountRepository(Context context) {
        this.context= context;
        this.db = new Database(context);
    }

    private boolean create_accout (Account account){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put("ID",);
        database.insert("ACCOUNT",null,values);
        return true;
    };
    private boolean getUsed_by (Account account){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();

        //database.query() select
        return true;
    };
}
