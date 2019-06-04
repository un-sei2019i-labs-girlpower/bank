package com.example.bank_app.BusinessLogic;

import android.content.Context;

import com.example.bank_app.DataAccess.Models.Account;
import com.example.bank_app.DataAccess.Models.User;

import com.example.bank_app.DataAccess.Repositories.*;

public class SendMoneyController {

private AccountRepository ar;
private UserRepository ur;
private Context context;

private static Account account1;
private static Account account2;
    public SendMoneyController(Context context) {
        this.context = context;
        this.ar = new AccountRepository(context);
    }

    private boolean verify_Amount (int user_identification, double amount){
        account1 = ar.getAccount_by(user_identification);
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


    public int sendMoney (int user_identification1, int  user_identification2, double amount){ //devuelve el caso 1. transaccion exitosa 2.

    }


    /* FALTA:
        UPDATE ACCOUNT
        CREATE TRANSACTION

     */
}
