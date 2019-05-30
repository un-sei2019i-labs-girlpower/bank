package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.DataAccess.DataBase.Database;
import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.Admin;

public class AdminRepository {
    Context context;
    Database db;

    public AdminRepository(Context context) {
        this.context= context;
        this.db = new Database(context);
    }

    private boolean create_accout (Admin admin){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put("ID",);
        database.insert("ACCOUNT",null,values);
        return true;
    };
}
