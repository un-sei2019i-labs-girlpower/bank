package com.example.bank_app.DataAccess.Models;

public class User {
    private int id_user;
    private int identification_user;
    private int password_user;
    private String name;
    private String email;
    private int phone;

    public User() {
        id_user=-1;
        identification_user=-1;
        password_user=-1;
        name= null;
        email=null;
        password_user=-1;
    }

    public User(int id_user, int identification_user, int password, String name, String email, int phone) {
        this.id_user = id_user;
        this.identification_user = identification_user;
        this.password_user = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId_user() {
        return id_user;
    }

    public int getIdentification_user() {
        return identification_user;
    }

    public int getPassword_user() {
        return password_user;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setIdentification_user(int identification_user) {
        this.identification_user = identification_user;
    }

    public void setPassword_user(int password_user) {
        this.password_user = password_user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
