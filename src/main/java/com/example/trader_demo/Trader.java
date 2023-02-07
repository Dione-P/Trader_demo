package com.example.trader_demo;

public class Trader {

    //attributes
    int t_id;
    String name;
    String email;
    double balance;
    String createdAt;
    String updatedAt;

    //constructors


    public Trader() {
    }

    //created for POST - payload accepted as JSON object
    public Trader(String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    //created for PUT - payload accepted as JSON object
    public Trader(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //created for PUT - payload accepted as JSON object
    public Trader(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Trader(int t_id, String name, String email, double balance, String createdAt, String updatedAt) {
        this.t_id = t_id;
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //getters and setters

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    //not required
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    //not required
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
