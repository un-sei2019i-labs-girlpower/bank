package com.example.bank_app.DataAccess.Models;

public class Admin {
    private int id;
    private int identification_admin;
    private String password_admin;

    public Admin(int id, int identification, String password) {
        this.id = id;
        this.identification_admin = identification;
        this.password_admin = password;
    }

    public int getId() {
        return id;
    }

    public int getIdentification_admin() {
        return identification_admin;
    }

    public String getPassword() {
        return password_admin;
    }
}
