package com.CGBank.DAO;

import com.CGBank.DAO.Account;

import java.util.List;

public class User {

    private int id ;
    private String username;
    private String password;
    private boolean isAdmin;


    // ----------------------------------------------------------------------------------------------
    // Constructor


    public User() { }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    // ----------------------------------------------------------------------------------------------
    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    // ----------------------------------------------------------------------------------------------
    // toString()

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }


    // ----------------------------------------------------------------------------------------------

}



