package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.DataAccess.DataBase.Database;
import com.example.bank_app.DataAccess.Models.Account;

import java.util.ArrayList;

public class AccountRepository {
    Context context;
    Database db;
    public AccountRepository(Context context) {
        this.context= context;
        this.db = new Database(context);
    }

    public boolean createAccout (Account account){

        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ACCOUNT_NUMBER", account.getAccount_number());
        values.put("AMOUNT", account.getAmount());
        values.put("ID_USER", account.getId_user());
        values.put("ID_ADMIN", account.getId_admin());
        database.insert("ACCOUNT",null,values);
        return true;
    };
    public Account getAccount_by (int ID_USERS_SEARCH){
        SQLiteDatabase database = db.getWritableDatabase();

        String[] columnas = new String[4];
        columnas[0]="ACCOUNT_NUMBER";
        columnas[1]="AMOUNT";
        columnas[2]="ID_USER";
        columnas[3]="ID_ADMIN";
        Cursor values =database.query("ACCOUNT",columnas,"ID_USER = '+"ID_USERS_SEARCH"+'",null,null,null,null,null);

        return new Account(values.getInt(0), values.getInt(3), values.getDouble(1), values.getInt(2));
    }
    public boolean updateAccount(Account actualizar , Account anterior){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ACCOUNT_NUMBER", actualizar.getAccount_number());
        values.put("AMOUNT", actualizar.getAmount());
        values.put("ID_USER", actualizar.getId_user());
        values.put("ID_ADMIN", actualizar.getId_admin());
        database.update("ACCOUNT",values, "ACCOUNT_NUMBER = '"+anterior.getAccount_number()+"'", null);

        return true;
    }
    public boolean delete_Account ( Account account){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        database.delete("ACCOUNT", "ACCOUNT_NUMBER = '"+account.getAccount_number()+"'", null);


        return true;
    }
}
