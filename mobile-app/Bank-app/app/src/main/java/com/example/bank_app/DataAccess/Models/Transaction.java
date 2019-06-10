package com.example.bank_app.DataAccess.Models;

public class Transaction {

    private int account_number;
    private int reference;
    private String date;
    private String type;
    private String information;

    public Transaction(int account_number, int reference, String date, String type) {
        this.account_number = account_number;
        this.reference = reference;
        this.date = date;
        this.type = type;
    }

    public int getAccount_number() {
        return account_number;
    }

    public int getReference() {
        return reference;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    
}
