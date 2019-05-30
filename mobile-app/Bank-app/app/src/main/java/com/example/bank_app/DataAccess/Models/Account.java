package com.example.bank_app.DataAccess.Models;

public class Account {
    private int number;
    private  int id_administrator;
    private double amount; //////////

    public Account(int number, int id_administrator, double amount) {
        this.number = number;
        this.id_administrator = id_administrator;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public int getId_administrator() {
        return id_administrator;
    }

    public double getAmount() {
        return amount;
    }
}
