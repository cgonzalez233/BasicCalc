package com.CGBank;

import com.CGBank.DAO.User;
import com.CGBank.DAO.UserDaoImpl;

import java.util.Scanner;

public class Menu {

    static Main main = new Main();
    static Scanner scan = new Scanner(System.in);
    static UserMethods userMethods = new UserMethods();
    static AdminMethods adminMethods = new AdminMethods();

    static User currentUser = null;

    //------------------------------------------------------------------------------------

    public static void mainMenu(){

        System.out.println("Welcome to the Bank of Christian! Please make a selection");
        System.out.println();
        System.out.println("1. Create an Account");
        System.out.println("2. Manage an existing account");
        System.out.println("3. Employee Login");

        int answer1 = scan.nextInt();

        switch(answer1){
            case 1:
                userMethods.newUser();
                main.run();
                break;
            case 2:
                userMethods.login();
                userMenu();
                break;
            case 3:
                userMethods.login();
                empMenu();
                break;
            default:
                System.out.println("Please enter an accepted number to continue!");
        }

    }

    //------------------------------------------------------------------------------------

    public static void userMenu(){

        if(currentUser == null){

            System.out.println("Invalid or incorrect login, Try Again");
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Return to Main Menu");

            int answer2 = scan.nextInt();

            switch(answer2){
                case 1:
                    userMethods.login();
                    userMenu();
                    break;
                case 2:
                    main.run();
                    break;
                default:
                    System.out.println("Please enter an accepted number to continue!");
            }

        }else {
            System.out.println("Welcome back " + currentUser.getUsername() + "! Please choose an option");
            System.out.println();
            System.out.println("1. Update Account");
            System.out.println("2. Withdraw Funds");
            System.out.println("3. Deposit Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Apply for New Account");
            System.out.println("6. Logout");
            System.out.println("0. Return to Main Menu");

            int answer3 = scan.nextInt();

            switch(answer3){
                case 1:
                    userMethods.updateUser();
                    userMenu();
                    break;
                case 2:
                    userMethods.withdraw();
                    userMenu();
                    break;
                case 3:
                    userMethods.deposit();
                    userMenu();
                    break;
                case 4:
                    userMethods.transfer();
                    userMenu();
                    break;
                case 5:
                    userMethods.apply();
                    userMenu();
                    break;
                case 6:
                    currentUser = null;
                    userMenu();
                    break;
                case 0:
                    main.run();
                    break;
                default:
                    System.out.println("Please enter an accepted account");

            }
        }

    }

    // ------------------------------------------------------------------------

    public static void empMenu(){
        if(currentUser == null || currentUser.isAdmin()){
            System.out.println("You are not currently logged in as an employee");
            System.out.println("Please login as an employee");
            System.out.println();
            System.out.println("1. Login as Employee");
            System.out.println("2. Return to Main Menu");

            int answer4 = scan.nextInt();

            switch(answer4){
                case 1:
                    userMethods.login();
                    empMenu();
                    break;
                case 2:
                    main.run();
                    break;
                default:
                    System.out.println("Please enter an accepted number");
            }

        }else{

            System.out.println("Welcome back " + currentUser.getUsername() + "! Please choose an option");
            System.out.println();
            System.out.println("1. Find All Users");
            System.out.println("2. Find Accounts by Username");
            System.out.println("3. Approve/Deny Account Application");
            System.out.println("4. Cancel A User Account");
            System.out.println("5. Promote to Employee");
            System.out.println("6. Logout");
            System.out.println("0. Return to Main Menu");

            int answer5 = scan.nextInt();

            switch (answer5){
                case 1:
                    adminMethods.findAllUsers();
                    break;
                case 2:
                    adminMethods.findByUsername();
                    break;
                case 3:
                    adminMethods.appApproval();
                    break;
                case 4:
                    adminMethods.deleteAcc();
                    break;
                case 5:
                    adminMethods.promote();
                    break;
                case 6:
                    currentUser = null;
                    break;
                case 0:
                    main.run();
                    break;
                default:
                    System.out.println("Please enter an accepted number");
            }

        }
    }

    // -------------------------------------------------------------------

}
