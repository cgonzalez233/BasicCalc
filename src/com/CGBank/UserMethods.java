package com.CGBank;

import com.CGBank.DAO.Account;
import com.CGBank.DAO.AccountDaoImpl;
import com.CGBank.DAO.User;
import com.CGBank.DAO.UserDaoImpl;
import com.CGBank.Exceptions.NotUniqueUsernameException;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserMethods {

    public static User currentUser = null;

    Scanner scan = new Scanner(System.in);
    UserDaoImpl userDao = new UserDaoImpl();
    AccountDaoImpl accountDao = new AccountDaoImpl();
    Random rand = new Random();

    public User login() throws SQLException {
        System.out.println("Please enter your username");
        String username = scan.next();

        System.out.println("Please enter your password");
        String pass = scan.next();

        User user = userDao.findByUsername(username);

        if(username.equals(user.getUsername()) && pass.equals(user.getPassword())){
            currentUser = user;
            System.out.println("Successfully Logged In!");
            return user;
        }else{
            System.out.println("Something went wrong!");
        }

     return null;
    }

    public void viewAccs() throws SQLException{

        List<Account> userAccs = accountDao.findAccByOwner(currentUser.getUsername());

        System.out.println();

        for(int i = 0; i < userAccs.size(); i++){
            System.out.println((i + 1) +
                    ". Account Id: " + userAccs.get(i).getId() +
                    ", Username: " + userAccs.get(i).getOwner() +
                    ", Balance: " + userAccs.get(i).getBalance() +
                    ", Active: " + userAccs.get(i).isActive());
        }

        System.out.println();

        System.out.println("Enter 1 to return");

        int back = scan.nextInt();

        switch (back){
            case 1:
                Menu.userMenu();
                break;
            default:
                System.out.println("Please enter an accepted number");
        }

    }

    public void deposit() throws SQLException {
        if(accountDao.findAccByOwner(currentUser.getUsername()).size() > 0){
            System.out.println("Please choose which account you would like to deposit into");
            System.out.println();
            List<Account> acc = accountDao.findAccByOwner(currentUser.getUsername());

            System.out.println();

            for(int i = 0; i < acc.size(); i++){
                System.out.println((i + 1) +
                        ". Account: " + acc.get(i).getId() +
                        ", Balance: " + acc.get(i).getBalance() +
                        ", Active: " + acc.get(i).isActive());
            }

            int answer = scan.nextInt();
            Account currentAcc = (acc.get(answer-1));

            if(answer <= acc.size() && answer > 0 && currentAcc.isActive()){
                System.out.println("Please enter deposit amount in dollars");
                System.out.println();
                double deposit = scan.nextDouble();
                accountDao.depositAcc(currentAcc.getId(), deposit);

            }else{
                System.out.println("Your account is not active yet");
            }
        }else {
            System.out.println("You do not have any bank accounts activated");
        }

    }

    public void withdraw() throws SQLException {
        if(accountDao.findAccByOwner(currentUser.getUsername()).size() > 0){
            System.out.println("Please choose which account you would like to withdraw from");
            System.out.println();
            List<Account> acc = accountDao.findAccByOwner(currentUser.getUsername());

            System.out.println();

            for(int i = 0; i < acc.size(); i++){
                System.out.println((i + 1) + ". " + acc.get(i).toString());
            }

            int answer = scan.nextInt();
            Account currentAcc = (acc.get(answer-1));

            try{
                if(answer <= acc.size() && answer > 0 && currentAcc.isActive()){
                    System.out.println("Please enter withdraw amount in dollars");
                    System.out.println();
                    double withdraw = scan.nextDouble();

                    if(currentAcc.isActive() && currentAcc.getBalance() > withdraw){
                        accountDao.withdrawAcc(currentAcc.getId(), withdraw);
                    }else{
                        System.out.println("You don't have the required funds");
                    }
                }else{
                    System.out.println("Your account is not active yet");
                }
            }catch(IndexOutOfBoundsException | SQLException exception){
                System.out.println("Please pick one of the options");
            }
        }else {
            System.out.println("You do not have any bank accounts activated");
            Menu.userMenu();
        }

    }

    public void transfer() throws SQLException {
        System.out.println("Please choose which account you would like to withdraw from");
        System.out.println();
        List<Account> accList = accountDao.findAccByOwner(currentUser.getUsername());

        System.out.println();

        for(int i = 0; i < accList.size(); i++){
            System.out.println((i + 1) + ". " + accList.get(i).toString());
        }

        int answer = scan.nextInt();
        Account acc1 = (accList.get(answer-1));

        if(answer <= accList.size() && answer > 0 && acc1.isActive()){
            System.out.println("Please enter withdraw amount in dollars");
            System.out.println();
            double transfer = scan.nextDouble();

            if(acc1.getBalance() > transfer){
                System.out.println("Please choose which account you would like to deposit into");
                System.out.println();


                for(int i = 0; i < accList.size(); i++){
                    System.out.println((i + 1) + ". " + accList.get(i).toString());
                }

                int answer2 = scan.nextInt();
                Account acc2 = (accList.get(answer2-1));

                if(answer2 <= accList.size() && answer2 > 0 && acc2.isActive()){

                    accountDao.withdrawAcc(acc1.getId(), transfer);
                    accountDao.depositAcc(acc2.getId(), transfer);

                }else{
                    System.out.println("Your account is not active yet");
                }
            }else{
                System.out.println("You don't have the required funds");
            }
        }else{
            System.out.println("Your account is not active yet");
        }


    }

    public void apply() throws SQLException {
        System.out.println("Do you want to apply for a bank account with CGBank?");
        System.out.println();
        System.out.println("1. Yes");
        System.out.println("2. No");

        int answer = scan.nextInt();

        switch(answer){
            case 1:
                Account acc = new Account(rand.nextInt(100000), currentUser.getUsername(), 0);
                accountDao.addAcc(acc);
                System.out.println("You have applied for an account!");
                System.out.println("Please wait for an employee to activate your new account");
                break;
            case 2:
                System.out.println("Please come back if you change your mind");
                break;
            default:
                System.out.println("Please enter an accepted number");
        }

    }

    public void newUser(){
        System.out.println("Welcome to CGBank!");
        System.out.println("------------------");
        System.out.println("To start, we need to set up an account");
        System.out.println("Please enter a unique username");

        String username = scan.next();

        System.out.println();
        System.out.println("Now enter a super secret password");

        String pass = scan.next();

        try{
            User user = new User(username, pass);
            userDao.addUser(user);
            System.out.println("Account successfully created!");

        }catch(NotUniqueUsernameException | SQLException ex){
            System.out.println("Please enter a unique username and password");
        }

    }

    public void updateUser() throws SQLException {
        System.out.println("Would you like to change your username or password?");
        System.out.println();
        System.out.println("1. Username");
        System.out.println("2. Password");

        int answer = scan.nextInt();

        switch(answer){
            case 1:
                System.out.println("Please enter the username you would like to change to");
                System.out.println();

                String newName = scan.next();

                userDao.updateUser(newName, currentUser.getPassword());
                System.out.println("Username Updated!");
                break;

            case 2:
                System.out.println("Please enter the password you would like to change to");
                System.out.println();

                String newPass = scan.next();

                userDao.updateUser(currentUser.getUsername(), newPass);

                System.out.println("Password Updated!");
                break;
            default:
                System.out.println("Please enter an accepted number");
        }


    }

}
