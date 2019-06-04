package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public boolean createAccout (Admin admin){

        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID_ADMIN", admin.getId());
        values.put("IDENTIFICATION_ADMIN", admin.getIdentification_admin());
        values.put("PASSWORD_ADMIN", admin.getPassword());
        database.insert("ADMIN",null,values);
        return true;
    };
    public Admin getAccount_by (int ID_ADMIN_SEARCH){
        SQLiteDatabase database = db.getWritableDatabase();

        String[] columnas = new String[3];
        columnas[0]="ID_ADMIN";
        columnas[1]="IDENTIFICATION_ADMIN";
        columnas[2]="PASSWORD_ADMIN";
        Cursor values =database.query("ADMIN",columnas,"ID_ADMIN = '"+ID_ADMIN_SEARCH+"'",null,null,null,null,null);

        return new Admin(values.getInt(0), values.getInt(1), values.getString(2));
    }
    public boolean updateAccount(Admin actualizar , Admin anterior){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID_ADMIN", actualizar.getId());
        values.put("IDENTIFICATION_ADMIN", actualizar.getIdentification_admin());
        values.put("PASSWORD_ADMIN", actualizar.getPassword());
        database.update("ADMIN",values, "ID_ADMIN = '"+anterior.getId()+"'", null);

        return true;
    }
    public boolean delete_Account ( Admin admin){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        database.delete("ADMIN", "ID_ADMIN = '"+admin.getId()+"'", null);


        return true;
    }
}
