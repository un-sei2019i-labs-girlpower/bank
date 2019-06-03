package com.example.bank_app.DataAccess.DataBase;
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
    private static final String cuenta_usuario = "CREATE TABLE USER (ID_USER INTEGER PRIMARY KEY, IDENTIFICATION_USER INTEGER, NAME TEXT, EMAIL TEXT, PHONE INTEGERID_USER,  PASSWORD_USER NUMBER)";
    private static final String cuenta_administrador = "CREATE TABLE ADMIN (ID_ADMIN INTEGER PRIMARY KEY,IDENTIFICATION_ADMIN INTEGER, PASSWORD_ADMIN TEXT ";

    static final String cuenta_bancaria = "CREATE TABLE ACCOUNT (ACCOUNT_NUMBER INTEGER PRIMARY KEY, AMOUNT REAL, ID_USER INTEGER, ID_ADMIN INTEGER," +
                                        "FOREIGN KEY (ID_USER) REFERENCES USER(ID_USER), FOREIGN KEY (ID_ADMIN) REFERENCES ADMIN(ID_ADMIN) )";

    static final String transaccion = "CREATE TABLE TRANSATION (ACCOUNT_NUMBER INTEGER PRIMARY KEY,REFERENCE INTEGER, DATE TEXT, INFORMATION TEXT, " +
                                        " FOREIGN KEY (ACCOUNT_NUMBER) REFERENCES ACCOUNT(ACCOUNT_NUMBER) )";

    public Database(Context context) {
        super(context, nombre, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(cuenta_usuario);
        sqLiteDatabase.execSQL(cuenta_administrador);
        sqLiteDatabase.execSQL(cuenta_bancaria);
        sqLiteDatabase.execSQL(transaccion);
        //sqLiteDatabase.execSQL();

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cuenta_usuario);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cuenta_administrador);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + cuenta_bancaria);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + transaccion);

        sqLiteDatabase.execSQL(cuenta_usuario);
        sqLiteDatabase.execSQL(cuenta_administrador);
        sqLiteDatabase.execSQL(cuenta_bancaria);
        sqLiteDatabase.execSQL(transaccion);
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


