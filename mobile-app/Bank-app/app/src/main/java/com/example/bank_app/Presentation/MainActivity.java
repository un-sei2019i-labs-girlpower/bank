package com.example.bank_app.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.DataAccess.Database;
import com.example.bank_app.R;

public class MainActivity extends AppCompatActivity {

    EditText editCog, edcontraseña;
    Button Afregar, Biniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCog = (EditText)findViewById(R.id.editID);
        edcontraseña = (EditText)findViewById(R.id.editContraseña);
        Afregar = (Button) findViewById(R.id.B_agregar);
        Biniciar= (Button) findViewById(R.id.B_iniciar);
        final Database database = new Database(getApplicationContext());

        Afregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.agregar_registro(editCog.getText().toString(),edcontraseña.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });
        Biniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(database.ingresar(editCog.getText().toString(), edcontraseña.getText().toString())){
                      Toast.makeText(getApplicationContext(), "SE INGRESO SECCION CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(MainActivity.this, Menu.class));

                    }else{
                    Toast.makeText(getApplicationContext(), "USUARIO NO ENCONTRADO", Toast.LENGTH_SHORT).show();

                }}
        });

      }


    }

