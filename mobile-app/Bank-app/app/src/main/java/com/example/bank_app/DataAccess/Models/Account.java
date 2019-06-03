package com.example.bank_app.DataAccess.Models;

public class Account {
    private int account_number;
    private  int id_admin;
    private  int id_user;
    private double amount; //////////

    public Account(int number, int id_administrator, double amount, int id_user) {
        this.account_number = number;
        this.id_admin = id_administrator;
        this.amount = amount;
        this.id_user = id_user;
    }

    public int getAccount_number() {
        return account_number;
    }

    public int getId_admin() {
        return id_admin;
    }

    public double getAmount() {
        return amount;
    }

    public int getId_user() {
        return id_user;
    }
}
