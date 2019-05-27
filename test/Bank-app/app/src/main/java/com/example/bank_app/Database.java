package com.example.bank_app;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;


public class Database extends SQLiteOpenHelper {

    private static final String nombre = "Database.bd";
    private static final int version = 1;
    private static final String table = "CREATE TABLE CURSO (CODIGO TEXT PRIMARY KEY, CONTRASEÑA TEXT )";

    public Database(Context context) {
        super(context, nombre, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table);
        sqLiteDatabase.execSQL(table);
    }

    public void agregar_registro(String primary_key, String contraseña) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {

            db.execSQL("INSERT INTO CURSO VALUES ('" + primary_key + "','" + contraseña + "')");
            db.close();
        }
        db.close();
    }


    public boolean ingresar(String id, String contraseña){

        SQLiteDatabase db = getWritableDatabase();
        Cursor curso =db.rawQuery("SELECT CODIGO, CONTRASEÑA FROM CURSO WHERE CODIGO='"+id+"'AND CONTRASEÑA ='"+contraseña+"'",null);
        if(curso.moveToFirst()){
            if(curso.getString(0).equals(id)
                    && curso.getString(1).equals(contraseña ))
            {
                return true;
            }
        }else{
            return false;

        }
        return false;
    }
}


