package com.example.bank_app.DataAccess.Models;

public class User {
    private int id_user;
    private int identification_user;
    private int password_user;
    private String name;
    private String email;
    private int phone;

    public User(int id_user, int identification, int password,String name, String email, int phone) {
        this.id_user = id_user;
        this.identification_user = identification;
        this.password_user = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId_user() {
        return id_user;
    }

    public int getIdentification() {
        return identification_user;
    }

    public int getPassword_user() {
        return password_user;
    }
    private void create_user (){};
    private int getUserById(){return 0;};
    private void updateUser(){};
    private void delateUser (){};
}
