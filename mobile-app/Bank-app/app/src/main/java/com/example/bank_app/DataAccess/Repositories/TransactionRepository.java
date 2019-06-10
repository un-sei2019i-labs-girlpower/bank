package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.DataAccess.DataBase.Database;
import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.Transaction;

public class TransactionRepository {
    Context context;
    Database db;

    public TransactionRepository(Context context) {
        this.context= context;
        this.db = new Database(context);
    }

    public boolean createTransaction (Transaction transaction){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ACCOUNT",transaction.getAccount_number());
        values.put("TYPE",transaction.getType()); ///////////// FALTA EN LA BASE DE DATOS
        values.put("REFERENCE",transaction.getReference());
        values.put("DATE",transaction.getDate());

        database.insert("TRANSATION",null,values);
        return true;
    };
}

