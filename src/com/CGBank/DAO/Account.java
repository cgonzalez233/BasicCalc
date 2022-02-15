package com.CGBank.DAO;

public class Account {

    private int id;
    private String owner;
    private double balance;
    private boolean isActive;
    private boolean isPending;

    // ----------------------------------------------------------------------------------------------


    public Account() {
    }

    public Account(int id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public Account(int id, String owner, double balance, boolean isActive, boolean isPending) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.isActive = isActive;
        this.isPending = isPending;
    }

    // ----------------------------------------------------------------------------------------------


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String ownerId) {
        this.owner = owner;
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

    public boolean isPending() {
        return isPending;
    }

    public void setPending(boolean pending) {
        isPending = pending;
    }

    // ----------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", isActive=" + isActive +
                ", isPending=" + isPending +
                '}';
    }


    // ----------------------------------------------------------------------------------------------
}
