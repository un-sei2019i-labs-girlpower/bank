package com.example.bank_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    Button enviar;
    TextView saldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        enviar = (Button) findViewById(R.id.B_enviar);
        saldo = (TextView) findViewById(R.id.T_saldo);
        final Database database = new Database(getApplicationContext());

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Send.class));
            }
        });

    }
}
