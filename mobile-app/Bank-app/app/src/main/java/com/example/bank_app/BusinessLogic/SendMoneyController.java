package com.example.bank_app.BusinessLogic;

import android.content.Context;

import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.Transaction;


import com.example.bank_app.DataAccess.Models.User;
import com.example.bank_app.DataAccess.Repositories.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.transform.sax.SAXSource;

public class SendMoneyController {
public static int referencia = 0;
private AccountRepository ar;
private UserRepository ur;
private TransactionRepository tr;
private Context context;

private static Account account1;
private static Account account2;
    public SendMoneyController(Context context) {
        this.context = context;
        this.ar = new AccountRepository(context);
        ur= new UserRepository(context);
        tr= new TransactionRepository(context);
        ar= new AccountRepository(context);
    }

    private boolean verify_Amount (int user_id, double amount){
        Account account1 = ar.getAccount_by(user_id);
        if(account1.getAmount()>=amount)
            return true;
        return false;
    }

    private boolean verify_account_recipient(int user_identification){
        account2 = ar.getAccount_by(user_identification);
        if(account2==null)
            return false;
        return true;
    }


    public int sendMoney (int user_identification1, int  user_identification2, double amount) { //devuelve el caso 1. transaccion exitosa 2. no hay suficiente saldo 3. el destinatario no existe
        System.out.println(user_identification1);
        // SE OBTIENE EL ID DE CADA USER (USER1 - ENVIA     USER2 - RECIBE)

        int id_u_1 = ur.getUserByIdentification(user_identification1).getId_user();

        // SE OBTIENEN LAS CUENTAS DE CADA USUARIO
        Account ac1 = ar.getAccount_by(id_u_1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date fecha = new Date();

        String date = dateFormat.format(fecha);

        if (verify_account_recipient(user_identification2)){ //SE VERIFICA QUE LA IDENTIFICACION DEL DESTINATARIO EXISTE EN LA BASE DE DATOS
            int id_u_2 = ur.getUserByIdentification(user_identification2).getId_user();
            Account ac2 = ar.getAccount_by(id_u_2);

            if (verify_Amount(id_u_1, amount)) { // SE VERIFICA QUE EL USUARIO QUE ENVIA TENGA SUFICIENTE SALDO

                // SE CREAN LAS CUENTAS ACTUALIZADAS PARA PASAR EN LA FUNCION UPDATEACCOUNT

                Account ac1N = new Account(ac1.getAccount_number(), 1, ac1.getAmount() - amount, id_u_1);
                Account ac2N = new Account(ac2.getAccount_number(), 1, ac2.getAmount() + amount, id_u_2);
                ar.updateAccount(ac1N, ac1);
                ar.updateAccount(ac2N, ac2);

                // SE CREA LA TRANSACCION PARA CADA USUARIO
                Transaction t1 = new Transaction(ac1.getAccount_number(), referencia++, date, "Sender"); //EL QUE ENVIA
                Transaction t2 = new Transaction(ac1.getAccount_number(), referencia++, date, "Payee"); //EL QUE RECIBE
                tr.createTransaction(t1);
                tr.createTransaction(t2);


                return 1;

            } else return 2;


    }else return 3;


    }


    /* FALTA:
        UPDATE ACCOUNT
        CREATE TRANSACTION

     */
}
