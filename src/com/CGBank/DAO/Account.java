package com.CGBank.DAO;

public class Account {

    private int id;
    private String accOwner;
    private double balance;
    private boolean isActive;

    // ----------------------------------------------------------------------------------------------

    public Account(String accOwner, double balance, boolean isActive) {
        this.accOwner = accOwner;
        this.balance = balance;
        this.isActive = isActive;
    }

    // ----------------------------------------------------------------------------------------------


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccOwner() {
        return accOwner;
    }

    public void setAccOwner(String accOwner) {
        this.accOwner = accOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // ----------------------------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accOwner='" + accOwner + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                '}';
    }

    // ----------------------------------------------------------------------------------------------
}
