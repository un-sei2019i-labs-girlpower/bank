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
    private static final String nombre = "Database.bd";
    private static final int version = 1;
    private static final String persona = "CREATE TABLE PERSONA (DOCUMENTO INTEGER PRIMARY KEY, NOMBRE TEXT, CORREO TEXT, CELULAR INTEGER )";
    private static final String cuenta_usuario = "CREATE TABLE CUENTA_USUARIOS (ID_USUARIO INTEGER PRIMARY KEY, CONTRASEÑA_USUARIO NUMBER )";
    private static final String cuenta_administrador = "CREATE TABLE CUENTA_ADMINISTRADOR (ID_ADMINISTRADOR INTEGER PRIMARY KEY, CONTRASEÑA_ADMINISTRADOR TEXT )";
    static final String cuenta_bancaria = "CREATE TABLE CUENTA_BANCARIA (NUMERO_CUENTA INTEGER PRIMARY KEY, ID INTEGER, MONTO REAL)";
    static final String transaccion = "CREATE TABLE TRANSACCION (NUMERO_TRA INTEGER PRIMARY KEY, REFERENCIA INTEGER PRIMARY KEY, FECHA TEXT, INFORMACION TEXT )";

    public Database(Context context) {
        super(context, nombre, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(persona);
        sqLiteDatabase.execSQL(cuenta_usuario);
        sqLiteDatabase.execSQL(cuenta_administrador);
        sqLiteDatabase.execSQL(cuenta_bancaria);
        sqLiteDatabase.execSQL(transaccion);
        sqLiteDatabase.execSQL();
        sqLiteDatabase.execSQL("INSERT INTO CUENTA_USUARIOS VALUES (USER1, 123)");
        sqLiteDatabase.execSQL("INSERT INTO CUENTA_USUARIOS VALUES (USER2, 123)";
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + persona);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cuenta_usuario);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cuenta_administrador);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cuenta_bancaria);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + transaccion);
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


