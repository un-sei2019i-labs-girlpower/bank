package com.example.bank_app.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.BusinessLogic.SignInController;
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
        Biniciar= (Button) findViewById(R.id.B_iniciar);
        final SignInController singIn = new SignInController(getApplicationContext());

        Biniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//singIn.sing(editCog.getText().toString(), edcontraseña.getText().toString())
              if(singIn.sing(editCog.getText().toString(), edcontraseña.getText().toString())){

                    Toast.makeText(getApplicationContext(), "SE INGRESO SECCION CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(MainActivity.this, SendMoneyActivity.class);
                      intent.putExtra("user_identification", editCog.getText().toString());
                      startActivity(intent);

              }else{
                    Toast.makeText(getApplicationContext(), "USUARIO O CONTRASEÑA INCORRECTO", Toast.LENGTH_SHORT).show();

                }}
        });

      }


    }

