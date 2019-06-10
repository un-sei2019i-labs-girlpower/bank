package com.example.bank_app.Presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.bank_app.BusinessLogic.SendMoneyController;
import com.example.bank_app.DataAccess.Repositories.AccountRepository;
import com.example.bank_app.DataAccess.Repositories.UserRepository;
import com.example.bank_app.R;

public class SendMoneyActivity extends AppCompatActivity {
    Button enviar;
    TextView saldo;
    EditText aumount, payee_identification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        aumount = (EditText)findViewById(R.id.Amount);
        payee_identification = (EditText)findViewById(R.id.payee_identification);
        enviar = (Button) findViewById(R.id.B_enviar);
        saldo = (TextView) findViewById(R.id.T_saldo);
        Bundle bundle = getIntent().getExtras();
        final int user_identification1 =  Integer.parseInt(bundle.getString("user_identification"));
        final SendMoneyController sendMoneyController = new SendMoneyController(getApplicationContext());

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int caso =  sendMoneyController.sendMoney(user_identification1, Integer.parseInt(payee_identification.getText().toString()),Double.parseDouble(aumount.getText().toString()));
                switch (caso){

                    case 1:
                        Toast.makeText(getApplicationContext(), "TRANSACCIÓN EXITOSA", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "SALDO INSUFICIENTE", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "DESTINATARIO NO EXISTENTE", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }
}
