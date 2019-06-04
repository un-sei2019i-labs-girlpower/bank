package com.example.bank_app.DataAccess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.DataAccess.DataBase.Database;
import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.User;

public class UserRepository {
    Context context;
    Database db;
    public UserRepository(Context context) {
        this.context= context;
        this.db = new Database(context);
    }
    public boolean createUser (User user){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID_USER", user.getId_user());
        values.put("IDENTIFICATION_USER", user.getIdentification_user());
        values.put("NAME", user.getName());
        values.put("EMAIL", user.getEmail());
        values.put("PHONE", user.getPhone());
        values.put("PASSWORD_USER NUMBER", user.getPassword_user());
        database.insert("USER",null,values);
        return true;
    };
    public User getUserByIdentification(int identification_user){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        User user= new User();
        String[] camp= {"ID_USER", "IDENTIFICATION_USER", "NAME", "EMAIL", "PHONE", "PASSWORD_USER NUMBER"};
        Cursor c=database.query("USER", camp,"IDENTIFICATION_USER='"+identification_user+"'",null,null, null,null);
        if(c==null)
            return null;
        user.setId_user(c.getInt(0));
        user.setIdentification_user(c.getInt(1));
        user.setName(c.getString(2));
        user.setEmail(c.getString(3));
        user.setPhone(c.getInt(4));
        user.setPassword_user(c.getInt(5));
        return user;
    };
    public boolean updateUser(User user){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID_USER", user.getId_user());
        values.put("IDENTIFICATION_USER", user.getIdentification_user());
        values.put("NAME", user.getName());
        values.put("EMAIL", user.getEmail());
        values.put("PHONE", user.getPhone());
        values.put("PASSWORD_USER NUMBER", user.getPassword_user());
        database.update("USER",values,"ID_USER='"+user.getId_user()+"'",null);
        return true;};
    public boolean delateUser (){return true;};
}
