package com.CGBank;

import com.CGBank.DAO.Account;
import com.CGBank.DAO.AccountDaoImpl;
import com.CGBank.DAO.User;
import com.CGBank.DAO.UserDaoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdminMethods {

    Scanner scan = new Scanner(System.in);
    UserDaoImpl userDao = new UserDaoImpl();
    AccountDaoImpl accountDao = new AccountDaoImpl();
    Random rand = new Random();

    // ----------------------------------------------------------------------------------------------
    // Method to promote a user account into an employee account

    public void hire() throws SQLException {
        System.out.println();
        System.out.println("Who is joining the CGBank family?");
        System.out.println();
        List<User> users = userDao.findAll();

        System.out.println();

        for (int i = 0; i < users.size(); i++) {
            if(!users.get(i).isAdmin()){
                System.out.println((i + 1) +
                        ". User Id: " + users.get(i).getId() +
                        ", Name: " + users.get(i).getFirstName() + " " + users.get(i).getLastName() +
                        ", Username: " + users.get(i).getUsername());
            }
        }

        System.out.println("Please enter a number or press 0 to return back to employee menu");

        int answer = scan.nextInt();
        if(answer==0){
            Menu.empMenu();
        }else{
            User hiredUser = (users.get(answer - 1));
            userDao.hireEmp(hiredUser.getId());
        }

    }

    // ----------------------------------------------------------------------------------------------
    // Show all users in the database

    public void findAllUsers() throws SQLException {

        List<User> users = userDao.findAll();

        System.out.println();

        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) +
                    ". User Id: " + users.get(i).getId() +
                    ", Name: " + users.get(i).getFirstName() + " " + users.get(i).getLastName() +
                    ", Username: " + users.get(i).getUsername() +
                    ", Employee: " + users.get(i).isAdmin());
        }
        System.out.println();

        System.out.println("Enter 1 to return to Employee Menu");

        int back = scan.nextInt();

        switch (back) {
            case 1:
                Menu.empMenu();
                break;
            default:
                System.out.println("Please enter an accepted number");
        }

    }

    // ----------------------------------------------------------------------------------------------
    // find an account by a specific username

    public void findByUsername() throws SQLException {
        System.out.println();
        System.out.println("Please enter the username of the account you'd like to find");
        System.out.println();

        String answer = scan.next();

        List<Account> ownerAcc = accountDao.findAccByOwner(answer);

        for (int i = 0; i < ownerAcc.size(); i++) {
            System.out.println((i + 1) +
                    ". Account Id: " + ownerAcc.get(i).getId() +
                    ", Username: " + ownerAcc.get(i).getOwner() +
                    ", Balance: " + ownerAcc.get(i).getBalance() +
                    ", Active: " + ownerAcc.get(i).isActive() +
                    ", Pending Approval: " + ownerAcc.get(i).isPending());
        }

        System.out.println();
        System.out.println("Enter 1 to return to Employee Menu");

        int back = scan.nextInt();

        switch (back) {
            case 1:
                Menu.empMenu();
                break;
            default:
                System.out.println("Please enter an accepted number");
        }

    }

    // ----------------------------------------------------------------------------------------------
    // Method to allow an employee to approve or deny an application for an account

    public void appApproval() throws SQLException {
        System.out.println();
        System.out.println("Here is a list of pending applications");

        List<Account> pendingAcc = accountDao.findByPending();

        if (pendingAcc.size() > 0) {
            for (int i = 0; i < pendingAcc.size(); i++) {
                System.out.println((i + 1) +
                        ". Account Id: " + pendingAcc.get(i).getId() +
                        ", Username: " + pendingAcc.get(i).getOwner() +
                        ", Balance: " + pendingAcc.get(i).getBalance() +
                        ", Pending Approval: " + pendingAcc.get(i).isPending());
            }

            System.out.println();
            System.out.println("Which account would you like to approve/deny?");
            System.out.println();

            int approve = scan.nextInt();
            Account approveAcc = (pendingAcc.get(approve - 1));

            if (approve <= pendingAcc.size() && approve > 0) {
                System.out.println();
                System.out.println("1. Approve");
                System.out.println("2. Deny");
                int choice = scan.nextInt();

                switch(choice){
                    case 1:
                        accountDao.activateAcc(approveAcc.getId());
                        break;
                    case 2:
                        accountDao.deleteAcc(approveAcc.getId());
                        break;
                    default:
                        System.out.println("Please enter an approved number");
                        break;
                }

            } else {
                System.out.println("Please enter a valid number");
                appApproval();
            }
        } else {
            System.out.println("There are no accounts to approve");
            Menu.empMenu();
        }


    }

    // ----------------------------------------------------------------------------------------------
    // Method to allow an employee to delete the account of a user

    public void deleteAcc() throws SQLException {
        System.out.println();
        System.out.println("Which user account would you like to remove?");
        System.out.println();
        List<Account> allAcc = accountDao.findAllAcc();

        if (allAcc.size() > 0) {
            for (int i = 0; i < allAcc.size(); i++) {
                System.out.println((i + 1) +
                        ". Account Id: " + allAcc.get(i).getId() +
                        ", Username: " + allAcc.get(i).getOwner() +
                        ", Balance: " + allAcc.get(i).getBalance() +
                        ", Active: " + allAcc.get(i).isActive());
            }

            System.out.println();
            System.out.println("Which account would you like to delete?");
            System.out.println();

            int delete = scan.nextInt();
            Account deleteAcc = (allAcc.get(delete - 1));

            if (delete <= allAcc.size() && delete > 0) {
                accountDao.deleteAcc(deleteAcc.getId());
            } else {
                System.out.println("Please enter a valid number");
                deleteAcc();
            }
        } else {
            System.out.println("There are no accounts to delete");
            Menu.empMenu();
        }

    }

    // ----------------------------------------------------------------------------------------------


}
