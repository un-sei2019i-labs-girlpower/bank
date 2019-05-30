package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.DataAccess.DataBase.Database;
import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.User;

public class userRepository {
    Context context;
    Database db;
    public userRepository(Context context) {
        this.context= context;
        this.db = new Database(context);
    }
    private boolean createUser (User user){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put("IDENTIFICATION_USER",);
        database.insert("USER",null,values);
        return true;
    };
    private int getUserById(){return 0;};
    private boolean updateUser(){return true;};
    private boolean delateUser (){return true;};
}
