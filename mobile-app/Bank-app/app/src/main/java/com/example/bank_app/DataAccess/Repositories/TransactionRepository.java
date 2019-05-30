package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.DataAccess.DataBase.Database;
import com.example.bank_app.DataAccess.Models.Account;

public class TransactionRepository {

    public TransactionRepository(Context context) {
        this.context= context;
        this.db = new Database(context);
    }

    private boolean createTransaction (Account account){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put("ID",);
        database.insert("TRANSATION",null,values);
        return true;
    };
}
