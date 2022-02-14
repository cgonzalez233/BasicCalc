package com.CGBank.DAO;

import com.CGBank.DAO.Account;

import java.util.List;

public class User {

    private int id ;
    private String username;
    private String password;
    private List<Account> accounts;
    private boolean isAdmin;
    private boolean isActive;


    // ----------------------------------------------------------------------------------------------
    // Constructor


    public User() { }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, List<Account> accounts, boolean isAdmin, boolean isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accounts = accounts;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // ----------------------------------------------------------------------------------------------
    // toString()

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accounts=" + accounts +
                ", isAdmin=" + isAdmin +
                ", isActive=" + isActive +
                '}';
    }


    // ----------------------------------------------------------------------------------------------

}



